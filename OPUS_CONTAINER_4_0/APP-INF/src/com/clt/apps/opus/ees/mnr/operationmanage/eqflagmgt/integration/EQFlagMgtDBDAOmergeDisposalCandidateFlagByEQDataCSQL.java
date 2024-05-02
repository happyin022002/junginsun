/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EQFlagMgtDBDAOmergeDisposalCandidateFlagByEQDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.09
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.03.09 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQFlagMgtDBDAOmergeDisposalCandidateFlagByEQDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQFlagMgtDBDAOmergeDisposalCandidateFlagByEQDataCSQL
	  * </pre>
	  */
	public EQFlagMgtDBDAOmergeDisposalCandidateFlagByEQDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_disp_sel_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_disp_sel_flg_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.integration").append("\n"); 
		query.append("FileName : EQFlagMgtDBDAOmergeDisposalCandidateFlagByEQDataCSQL").append("\n"); 
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
		query.append("MERGE INTO MNR_EQ_STS A" ).append("\n"); 
		query.append("USING DUAL" ).append("\n"); 
		query.append("ON (EQ_NO = @[eq_no])" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET DISP_RSN_CD = @[disp_rsn_cd]," ).append("\n"); 
		query.append("MNR_DISP_SEL_TP_CD = 'N'," ).append("\n"); 
		query.append("MNR_DISP_SEL_FLG = DECODE(@[mnr_disp_sel_flg],'1','Y','N')," ).append("\n"); 
		query.append("MNR_DISP_SEL_FLG_DT =DECODE(@[mnr_disp_sel_flg],'1',SYSDATE,null)," ).append("\n"); 
		query.append("MNR_DISP_SEL_FLG_YD_CD = DECODE(@[mnr_disp_sel_flg],'1',@[mnr_disp_sel_flg_yd_cd], null)," ).append("\n"); 
		query.append("RPR_COST_AMT = 0," ).append("\n"); 
		query.append("UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("EQ_NO" ).append("\n"); 
		query.append(",EQ_KND_CD" ).append("\n"); 
		query.append(",DISP_RSN_CD" ).append("\n"); 
		query.append(",EQ_TPSZ_CD" ).append("\n"); 
		query.append(",MNR_DISP_SEL_TP_CD" ).append("\n"); 
		query.append(",MNR_DISP_SEL_FLG" ).append("\n"); 
		query.append(",MNR_DISP_SEL_FLG_DT" ).append("\n"); 
		query.append(",MNR_DISP_SEL_FLG_YD_CD" ).append("\n"); 
		query.append(",RPR_COST_AMT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[eq_no]" ).append("\n"); 
		query.append(",@[eq_knd_cd]" ).append("\n"); 
		query.append(",@[disp_rsn_cd]" ).append("\n"); 
		query.append(",@[eq_tpsz_cd]" ).append("\n"); 
		query.append(",'N'" ).append("\n"); 
		query.append(",DECODE(@[mnr_disp_sel_flg],'1','Y','N')" ).append("\n"); 
		query.append(",DECODE(@[mnr_disp_sel_flg],'1',SYSDATE,null)" ).append("\n"); 
		query.append(",DECODE(@[mnr_disp_sel_flg],'1',@[mnr_disp_sel_flg_yd_cd],null)" ).append("\n"); 
		query.append(",0" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}