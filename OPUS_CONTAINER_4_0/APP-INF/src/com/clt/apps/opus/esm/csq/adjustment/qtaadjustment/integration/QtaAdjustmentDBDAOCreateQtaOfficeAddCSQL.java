/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : QtaAdjustmentDBDAOCreateQtaOfficeAddCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.13 
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

public class QtaAdjustmentDBDAOCreateQtaOfficeAddCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2013.12.10 PEJ [CHM-201328059] QTA Edit_Office Add 팝업 추가
	  *                                                  [IAS QTA Office Add]을 [생성] 합니다.
	  * </pre>
	  */
	public QtaAdjustmentDBDAOCreateQtaOfficeAddCSQL(){
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
		params.put("f_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOCreateQtaOfficeAddCSQL").append("\n"); 
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
		query.append("INSERT INTO CSQ_CFM_QTA" ).append("\n"); 
		query.append("SELECT A2.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("      ,A2.BSE_TP_CD" ).append("\n"); 
		query.append("      ,A2.BSE_YR" ).append("\n"); 
		query.append("      ,A2.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,A1.OFC_VW_CD" ).append("\n"); 
		query.append("      ,A2.QTA_TGT_CD" ).append("\n"); 
		query.append("      ,A2.TRD_CD" ).append("\n"); 
		query.append("      ,A2.RLANE_CD" ).append("\n"); 
		query.append("      ,A2.DIR_CD" ).append("\n"); 
		query.append("      ,A2.VSL_CD" ).append("\n"); 
		query.append("      ,A2.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A2.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,A1.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,A1.RHQ_CD" ).append("\n"); 
		query.append("      ,NVL((SELECT N3RD_PRNT_OFC_CD FROM CSQ_ORGANIZATION_V WHERE OFC_CD = A1.RGN_OFC_CD ),'') AS AQ_CD" ).append("\n"); 
		query.append("      ,A2.CONV_DIR_CD" ).append("\n"); 
		query.append("      ,0 AS LOD_QTY" ).append("\n"); 
		query.append("      ,0 AS GRS_RPB_REV" ).append("\n"); 
		query.append("      ,0 AS PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,0 AS RA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,'M'  AS CSQ_CNG_TP_CD" ).append("\n"); 
		query.append("      ,@[f_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("      ,@[f_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("  FROM CSQ_QTA_LANE_OFC A1" ).append("\n"); 
		query.append("      ,CSQ_CFM_TGT_VVD A2" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD       = A2.BSE_TP_CD" ).append("\n"); 
		query.append("   AND A1.BSE_YR          = A2.BSE_YR" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD      = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND A1.TRD_CD          = A2.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD        = A2.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.DIR_CD          = A2.DIR_CD   " ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD       = @[bse_tp_cd]" ).append("\n"); 
		query.append("   AND A1.BSE_YR          = @[bse_yr]" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD      = DECODE(@[bse_tp_cd], 'Y', '00', @[bse_qtr_cd]) " ).append("\n"); 
		query.append("   AND A1.OFC_VW_CD       = @[ofc_vw_cd]" ).append("\n"); 
		query.append("   AND A1.TRD_CD          = @[trd_cd]" ).append("\n"); 
		query.append("   AND A1.RLANE_CD        = @[rlane_cd]" ).append("\n"); 
		query.append("   AND A1.DIR_CD          = @[dir_cd]" ).append("\n"); 
		query.append("   AND A1.RGN_OFC_CD      IN (@[rgn_ofc_cd])" ).append("\n"); 
		query.append("   AND A2.QTA_RLSE_VER_NO LIKE '%02'" ).append("\n"); 

	}
}