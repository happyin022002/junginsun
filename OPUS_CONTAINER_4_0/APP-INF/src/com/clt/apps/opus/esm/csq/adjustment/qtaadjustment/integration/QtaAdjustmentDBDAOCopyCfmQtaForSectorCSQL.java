/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : QtaAdjustmentDBDAOCopyCfmQtaForSectorCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.02.13 
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

public class QtaAdjustmentDBDAOCopyCfmQtaForSectorCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COPY VVD 기준의 CSQ_SCTR_CFM_QTA 데이터를 복사한다.
	  * </pre>
	  */
	public QtaAdjustmentDBDAOCopyCfmQtaForSectorCSQL(){
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
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coa_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("copy_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOCopyCfmQtaForSectorCSQL").append("\n"); 
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
		query.append("INSERT INTO CSQ_SCTR_CFM_QTA(QTA_RLSE_VER_NO, BSE_TP_CD, BSE_YR, BSE_QTR_CD, OFC_VW_CD, RLANE_CD, DIR_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, RGN_OFC_CD, POL_CD, POD_CD, PF_GRP_CD, TRD_CD, SUB_TRD_CD, RHQ_CD, AQ_CD, FNL_BSA_CAPA, LOD_QTY, GRS_RPB_REV, PA_CM_UC_AMT, RA_CM_UC_AMT, POL_CALL_SEQ, POD_CALL_SEQ, CSQ_CNG_TP_CD, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT )" ).append("\n"); 
		query.append("SELECT QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("      ,BSE_TP_CD" ).append("\n"); 
		query.append("      ,BSE_YR" ).append("\n"); 
		query.append("      ,BSE_QTR_CD" ).append("\n"); 
		query.append("      ,OFC_VW_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,DIR_CD" ).append("\n"); 
		query.append("      ,SUBSTR(@[coa_vvd],1,4) AS VSL_CD" ).append("\n"); 
		query.append("      ,SUBSTR(@[coa_vvd],5,4) AS SKD_VOY_NO" ).append("\n"); 
		query.append("      ,SUBSTR(@[coa_vvd],9,1) AS SKD_DIR_CD" ).append("\n"); 
		query.append("      ,RGN_OFC_CD" ).append("\n"); 
		query.append("      ,POL_CD" ).append("\n"); 
		query.append("      ,POD_CD" ).append("\n"); 
		query.append("      ,PF_GRP_CD" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,SUB_TRD_CD" ).append("\n"); 
		query.append("      ,RHQ_CD" ).append("\n"); 
		query.append("      ,AQ_CD" ).append("\n"); 
		query.append("      ,FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,LOD_QTY" ).append("\n"); 
		query.append("      ,GRS_RPB_REV" ).append("\n"); 
		query.append("      ,PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,RA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,POL_CALL_SEQ" ).append("\n"); 
		query.append("      ,POD_CALL_SEQ" ).append("\n"); 
		query.append("      ,CSQ_CNG_TP_CD" ).append("\n"); 
		query.append("      ,@[usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE   AS CRE_DT" ).append("\n"); 
		query.append("      ,@[usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE   AS UPD_DT " ).append("\n"); 
		query.append("  FROM CSQ_SCTR_CFM_QTA" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND QTA_RLSE_VER_NO = SUBSTR(@[bse_yr],-2) ||@[bse_qtr_cd]||'02'" ).append("\n"); 
		query.append("   AND BSE_TP_CD       = @[bse_tp_cd]" ).append("\n"); 
		query.append("   AND BSE_YR          = @[bse_yr]" ).append("\n"); 
		query.append("   AND BSE_QTR_CD      = @[bse_qtr_cd]" ).append("\n"); 
		query.append("   AND RLANE_CD        = @[rlane_cd]" ).append("\n"); 
		query.append("   AND DIR_CD          = @[dir_cd]" ).append("\n"); 
		query.append("   AND VSL_CD          = SUBSTR(@[copy_vvd],1,4)" ).append("\n"); 
		query.append("   AND SKD_VOY_NO      = SUBSTR(@[copy_vvd],5,4)" ).append("\n"); 
		query.append("   AND SKD_DIR_CD      = SUBSTR(@[copy_vvd],9,1)" ).append("\n"); 

	}
}