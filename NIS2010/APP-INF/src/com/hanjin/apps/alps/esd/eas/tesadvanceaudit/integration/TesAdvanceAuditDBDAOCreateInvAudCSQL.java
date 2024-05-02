/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TesAdvanceAuditDBDAOCreateInvAudCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TesAdvanceAuditDBDAOCreateInvAudCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Auto Audit 결과를 등록 수정한다.
	  * </pre>
	  */
	public TesAdvanceAuditDBDAOCreateInvAudCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expn_aud_estm_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_inv_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_expn_aud_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_prd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vol_aud_tgt_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amt_aud_tgt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_prd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bat_amt_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bat_estm_vol_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bat_vol_rslt_cd_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bat_vol_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vrfy_rslt_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("calc_tp_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aud_dtl_tgt_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aud_lgs_cost_cd_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bat_estm_vol_rslt_cd_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bat_amt_rslt_cd_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration").append("\n"); 
		query.append("FileName : TesAdvanceAuditDBDAOCreateInvAudCSQL").append("\n"); 
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
		query.append("MERGE INTO EAS_TML_AUD K USING(" ).append("\n"); 
		query.append("		SELECT	  @[inv_no] AS INV_NO" ).append("\n"); 
		query.append("				, @[vndr_seq] AS VNDR_SEQ" ).append("\n"); 
		query.append("				, TO_DATE(@[inv_cfm_dt], 'YYYYMMDDHH24MISS') AS INV_CFM_DT" ).append("\n"); 
		query.append("				, @[vsl_cd] AS VSL_CD" ).append("\n"); 
		query.append("				, @[skd_voy_no] AS SKD_VOY_NO" ).append("\n"); 
		query.append("				, @[skd_dir_cd] AS SKD_DIR_CD" ).append("\n"); 
		query.append("				, @[io_bnd_cd] AS IO_BND_CD" ).append("\n"); 
		query.append("		FROM DUAL" ).append("\n"); 
		query.append("		) B" ).append("\n"); 
		query.append("	ON	( K.INV_NO				= B.INV_NO" ).append("\n"); 
		query.append("	AND	K.VNDR_SEQ				= B.VNDR_SEQ" ).append("\n"); 
		query.append("	AND	K.INV_CFM_DT			= B.INV_CFM_DT" ).append("\n"); 
		query.append("	AND	NVL(K.VSL_CD, 'X')		= NVL(B.VSL_CD, 'X')" ).append("\n"); 
		query.append("	AND	NVL(K.SKD_VOY_NO, 'X')	= NVL(B.SKD_VOY_NO, 'X')" ).append("\n"); 
		query.append("	AND	NVL(K.SKD_DIR_CD, 'X')	= NVL(B.SKD_DIR_CD, 'X')" ).append("\n"); 
		query.append("	AND	NVL(K.IO_BND_CD, 'X')	= NVL(B.IO_BND_CD, 'X')" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	WHEN MATCHED THEN" ).append("\n"); 
		query.append("	UPDATE" ).append("\n"); 
		query.append("	SET	  K.CURR_CD				= @[curr_cd]" ).append("\n"); 
		query.append("		, K.INV_AMT				= NVL(K.INV_AMT, 0) + TO_NUMBER(@[inv_amt]) 						-- CALC_COST_GRP_CD 가 2개 이상일 경우 SUM" ).append("\n"); 
		query.append("		, K.EXPN_AUD_ESTM_AMT	= NVL(K.EXPN_AUD_ESTM_AMT, 0) + TO_NUMBER(@[expn_aud_estm_amt]) 	-- CALC_COST_GRP_CD 가 2개 이상일 경우 SUM" ).append("\n"); 
		query.append("		, K.AMT_AUD_TGT_FLG		= GREATEST(NVL(K.AMT_AUD_TGT_FLG, 'A'), @[amt_aud_tgt_flg]) 		-- CALC_COST_GRP_CD 가 2개중 하나라도 'Y'이면 'Y'" ).append("\n"); 
		query.append("		, K.AUD_LGS_COST_CD_QTY	= NVL(K.AUD_LGS_COST_CD_QTY, 0) + TO_NUMBER(@[aud_lgs_cost_cd_qty]) -- CALC_COST_GRP_CD 가 2개 이상일 경우 SUM" ).append("\n"); 
		query.append("		, K.VRFY_RSLT_CD_CTNT	= TRIM((CASE WHEN NVL(K.VRFY_RSLT_CD_CTNT, ' ') = @[vrfy_rslt_cd_ctnt] " ).append("\n"); 
		query.append("											THEN K.VRFY_RSLT_CD_CTNT ELSE NVL(K.VRFY_RSLT_CD_CTNT, ' ') ||' '|| @[vrfy_rslt_cd_ctnt]" ).append("\n"); 
		query.append("										END)) 														-- CALC_COST_GRP_CD 가 2개 이상일 경우 CONCAT" ).append("\n"); 
		query.append("		, K.VOL_AUD_TGT_QTY		= NVL(K.VOL_AUD_TGT_QTY, 0) + TO_NUMBER(@[vol_aud_tgt_qty]) 		-- CALC_COST_GRP_CD 가 2개 이상일 경우 SUM" ).append("\n"); 
		query.append("		, K.BAT_VOL_RSLT_CD		= LEAST(NVL(K.BAT_VOL_RSLT_CD, 'Z'), @[bat_vol_rslt_cd]) 			-- CALC_COST_GRP_CD 가 2개중 하나라도 'F'이면 'F'" ).append("\n"); 
		query.append("		, K.BAT_AMT_RSLT_CD		= LEAST(NVL(K.BAT_AMT_RSLT_CD, 'Z'), @[bat_amt_rslt_cd]) 			-- CALC_COST_GRP_CD 가 2개중 하나라도 'F'이면 'F'" ).append("\n"); 
		query.append("		, K.BAT_ESTM_VOL_RSLT_CD= LEAST(NVL(K.BAT_ESTM_VOL_RSLT_CD, 'Z'), @[bat_estm_vol_rslt_cd])	-- CALC_COST_GRP_CD 가 2개중 하나라도 'F'이면 'F'" ).append("\n"); 
		query.append("		, K.AUTO_EXPN_AUD_STS_CD= LEAST(NVL(K.AUTO_EXPN_AUD_STS_CD, 'Z'), @[auto_expn_aud_sts_cd])	-- CALC_COST_GRP_CD 가 2개중 하나라도 심사 대상이면 심사대상으로 선정" ).append("\n"); 
		query.append("		, K.AUD_DTL_TGT_QTY		= NVL(K.AUD_DTL_TGT_QTY, 0) + @[aud_dtl_tgt_qty]					-- CALC_COST_GRP_CD 가 2개 이상일 경우 detail의 갯수를 모두 SUM" ).append("\n"); 
		query.append("		, K.CALC_TP_CD_CTNT		= TRIM((CASE WHEN NVL(K.CALC_TP_CD_CTNT, ' ') = @[calc_tp_cd_ctnt] THEN K.CALC_TP_CD_CTNT ELSE NVL(K.CALC_TP_CD_CTNT, ' ') ||' '|| @[calc_tp_cd_ctnt] END))" ).append("\n"); 
		query.append("		, K.BAT_VOL_RSLT_CD_QTY	= NVL(K.BAT_VOL_RSLT_CD_QTY, 0) + @[bat_vol_rslt_cd_qty]			-- CALC_COST_GRP_CD 가 2개 이상일 경우 detail의 갯수를 모두 SUM" ).append("\n"); 
		query.append("		, K.BAT_AMT_RSLT_CD_QTY	= NVL(K.BAT_AMT_RSLT_CD_QTY, 0) + @[bat_amt_rslt_cd_qty]			-- CALC_COST_GRP_CD 가 2개 이상일 경우 detail의 갯수를 모두 SUM" ).append("\n"); 
		query.append("		, K.BAT_ESTM_VOL_RSLT_CD_QTY= NVL(K.BAT_ESTM_VOL_RSLT_CD_QTY, 0) + @[bat_estm_vol_rslt_cd_qty] -- CALC_COST_GRP_CD 가 2개 이상일 경우 detail의 갯수를 모두 SUM" ).append("\n"); 
		query.append("		, K.FM_PRD_DT			= @[fm_prd_dt]" ).append("\n"); 
		query.append("		, K.TO_PRD_DT			= @[to_prd_dt]" ).append("\n"); 
		query.append("		, K.UPD_DT				= SYSDATE" ).append("\n"); 
		query.append("		, K.UPD_USR_ID			= 'Batch'" ).append("\n"); 
		query.append("	WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("	INSERT (" ).append("\n"); 
		query.append("		  K.INV_NO" ).append("\n"); 
		query.append("		, K.VNDR_SEQ" ).append("\n"); 
		query.append("		, K.INV_CFM_DT" ).append("\n"); 
		query.append("		, K.EXPN_AUD_SEQ" ).append("\n"); 
		query.append("		, K.VSL_CD" ).append("\n"); 
		query.append("		, K.SKD_VOY_NO" ).append("\n"); 
		query.append("		, K.SKD_DIR_CD" ).append("\n"); 
		query.append("		, K.IO_BND_CD" ).append("\n"); 
		query.append("		, K.ATB_DT" ).append("\n"); 
		query.append("		, K.FM_PRD_DT" ).append("\n"); 
		query.append("		, K.TO_PRD_DT" ).append("\n"); 
		query.append("		, K.TML_INV_TP_CD" ).append("\n"); 
		query.append("		, K.YD_CD" ).append("\n"); 
		query.append("		, K.ISS_DT" ).append("\n"); 
		query.append("		, K.RHQ_CD" ).append("\n"); 
		query.append("		, K.INV_OFC_CD" ).append("\n"); 
		query.append("		, K.COST_OFC_CD" ).append("\n"); 
		query.append("		, K.CURR_CD" ).append("\n"); 
		query.append("		, K.INV_AMT" ).append("\n"); 
		query.append("		, K.EXPN_AUD_ESTM_AMT" ).append("\n"); 
		query.append("		, K.AMT_AUD_TGT_FLG" ).append("\n"); 
		query.append("		, K.AUD_LGS_COST_CD_QTY" ).append("\n"); 
		query.append("		, K.VRFY_RSLT_CD_CTNT" ).append("\n"); 
		query.append("		, K.VOL_AUD_TGT_QTY" ).append("\n"); 
		query.append("		, K.BAT_VOL_RSLT_CD" ).append("\n"); 
		query.append("		, K.BAT_AMT_RSLT_CD" ).append("\n"); 
		query.append("		, K.BAT_ESTM_VOL_RSLT_CD" ).append("\n"); 
		query.append("		, K.AUTO_EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("		, K.AUD_DTL_TGT_QTY" ).append("\n"); 
		query.append("		, K.CALC_TP_CD_CTNT" ).append("\n"); 
		query.append("		, K.BAT_VOL_RSLT_CD_QTY" ).append("\n"); 
		query.append("		, K.BAT_AMT_RSLT_CD_QTY" ).append("\n"); 
		query.append("		, K.BAT_ESTM_VOL_RSLT_CD_QTY" ).append("\n"); 
		query.append("		, K.CRE_USR_ID" ).append("\n"); 
		query.append("		, K.CRE_DT" ).append("\n"); 
		query.append("		, K.UPD_USR_ID" ).append("\n"); 
		query.append("		, K.UPD_DT" ).append("\n"); 
		query.append("	) VALUES(" ).append("\n"); 
		query.append("		  @[inv_no]" ).append("\n"); 
		query.append("		, @[vndr_seq]" ).append("\n"); 
		query.append("		, TO_DATE(@[inv_cfm_dt],  'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("		, NVL((SELECT	MAX(X.EXPN_AUD_SEQ) + 1" ).append("\n"); 
		query.append("			FROM	EAS_TML_AUD X" ).append("\n"); 
		query.append("			WHERE	X.INV_NO		= B.INV_NO" ).append("\n"); 
		query.append("			AND		X.VNDR_SEQ		= B.VNDR_SEQ" ).append("\n"); 
		query.append("			AND		X.INV_CFM_DT	= B.INV_CFM_DT" ).append("\n"); 
		query.append("			), 1)" ).append("\n"); 
		query.append("		, @[vsl_cd]" ).append("\n"); 
		query.append("		, @[skd_voy_no]" ).append("\n"); 
		query.append("		, @[skd_dir_cd]" ).append("\n"); 
		query.append("		, @[io_bnd_cd]" ).append("\n"); 
		query.append("		, TO_DATE(@[atb_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("		, @[fm_prd_dt]" ).append("\n"); 
		query.append("		, @[to_prd_dt]" ).append("\n"); 
		query.append("		, @[tml_inv_tp_cd]" ).append("\n"); 
		query.append("		, @[yd_cd]" ).append("\n"); 
		query.append("		, TO_DATE(@[iss_dt] , 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("		, @[rhq_cd]" ).append("\n"); 
		query.append("		, @[inv_ofc_cd]" ).append("\n"); 
		query.append("		, @[cost_ofc_cd]" ).append("\n"); 
		query.append("		, @[curr_cd]" ).append("\n"); 
		query.append("		, @[inv_amt]" ).append("\n"); 
		query.append("		, @[expn_aud_estm_amt]" ).append("\n"); 
		query.append("		, @[amt_aud_tgt_flg]" ).append("\n"); 
		query.append("		, @[aud_lgs_cost_cd_qty]" ).append("\n"); 
		query.append("		, @[vrfy_rslt_cd_ctnt]" ).append("\n"); 
		query.append("		, NVL(@[vol_aud_tgt_qty], 0)" ).append("\n"); 
		query.append("		, @[bat_vol_rslt_cd]" ).append("\n"); 
		query.append("		, @[bat_amt_rslt_cd]" ).append("\n"); 
		query.append("		, @[bat_estm_vol_rslt_cd]" ).append("\n"); 
		query.append("		, @[auto_expn_aud_sts_cd]" ).append("\n"); 
		query.append("		, @[aud_dtl_tgt_qty]" ).append("\n"); 
		query.append("		, @[calc_tp_cd_ctnt]" ).append("\n"); 
		query.append("		, NVL(@[bat_vol_rslt_cd_qty], 0)" ).append("\n"); 
		query.append("		, NVL(@[bat_amt_rslt_cd_qty], 0)" ).append("\n"); 
		query.append("		, NVL(@[bat_estm_vol_rslt_cd_qty], 0)" ).append("\n"); 
		query.append("		, 'Batch'" ).append("\n"); 
		query.append("		, SYSDATE" ).append("\n"); 
		query.append("		, 'Batch'" ).append("\n"); 
		query.append("		, SYSDATE" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}