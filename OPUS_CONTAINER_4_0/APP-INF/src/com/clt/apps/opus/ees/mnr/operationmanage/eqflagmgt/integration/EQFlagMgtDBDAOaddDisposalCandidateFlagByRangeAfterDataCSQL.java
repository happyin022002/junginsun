/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EQFlagMgtDBDAOaddDisposalCandidateFlagByRangeAfterDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQFlagMgtDBDAOaddDisposalCandidateFlagByRangeAfterDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQFlagMgtDBDAOaddDisposalCandidateFlagByRangeAfterDataCSQL
	  * </pre>
	  */
	public EQFlagMgtDBDAOaddDisposalCandidateFlagByRangeAfterDataCSQL(){
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
		params.put("fm_ser_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lot_eq_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.integration").append("\n"); 
		query.append("FileName : EQFlagMgtDBDAOaddDisposalCandidateFlagByRangeAfterDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_EQ_STS(" ).append("\n"); 
		query.append("          EQ_NO" ).append("\n"); 
		query.append("        ,EQ_KND_CD" ).append("\n"); 
		query.append("        ,DISP_RSN_CD" ).append("\n"); 
		query.append("        ,EQ_TPSZ_CD" ).append("\n"); 
		query.append("		,MNR_DISP_SEL_TP_CD" ).append("\n"); 
		query.append("        ,MNR_DISP_SEL_FLG" ).append("\n"); 
		query.append("        ,MNR_DISP_SEL_FLG_DT" ).append("\n"); 
		query.append("     	,MNR_DISP_SEL_FLG_YD_CD" ).append("\n"); 
		query.append("        ,CRE_USR_ID" ).append("\n"); 
		query.append("        ,CRE_DT" ).append("\n"); 
		query.append("        ,UPD_USR_ID" ).append("\n"); 
		query.append("        ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${eq_knd_cd} == 'U')" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("            A.CNTR_NO" ).append("\n"); 
		query.append("           ,@[eq_knd_cd]" ).append("\n"); 
		query.append("		   ,'C'" ).append("\n"); 
		query.append("           ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("           ,'R'" ).append("\n"); 
		query.append("           ,DECODE(@[mnr_disp_sel_flg],'1','Y','N')" ).append("\n"); 
		query.append("           ,DECODE(@[mnr_disp_sel_flg],'1',SYSDATE,null)" ).append("\n"); 
		query.append("           ,DECODE(@[mnr_disp_sel_flg],'1',A.CRNT_YD_CD,null)" ).append("\n"); 
		query.append("           ,@[cre_usr_id]" ).append("\n"); 
		query.append("           ,SYSDATE" ).append("\n"); 
		query.append("           ,@[upd_usr_id]" ).append("\n"); 
		query.append("           ,SYSDATE" ).append("\n"); 
		query.append("FROM  MST_CONTAINER A" ).append("\n"); 
		query.append("WHERE A.CNTR_NO BETWEEN @[lot_eq_pfx_cd] || @[fm_ser_no] || '0'  AND @[lot_eq_pfx_cd] || @[to_ser_no] ||'9' " ).append("\n"); 
		query.append("  AND A.LSTM_CD = 'OW'" ).append("\n"); 
		query.append("  AND NOT EXISTS(SELECT" ).append("\n"); 
		query.append("                       EQ_NO" ).append("\n"); 
		query.append("                       FROM MNR_EQ_STS" ).append("\n"); 
		query.append("					   WHERE EQ_NO =A.CNTR_NO" ).append("\n"); 
		query.append("                       ) " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("            C.EQ_NO" ).append("\n"); 
		query.append("           ,@[eq_knd_cd]" ).append("\n"); 
		query.append("		   ,'C'" ).append("\n"); 
		query.append("           ,C.EQ_TPSZ_CD" ).append("\n"); 
		query.append("		   ,'R'" ).append("\n"); 
		query.append("           ,DECODE(@[mnr_disp_sel_flg],'1','Y','N')" ).append("\n"); 
		query.append("           ,DECODE(@[mnr_disp_sel_flg],'1',SYSDATE,null)" ).append("\n"); 
		query.append("           ,DECODE(@[mnr_disp_sel_flg],'1',C.CHSS_MVMT_DEST_YD_CD,null)" ).append("\n"); 
		query.append("           ,@[cre_usr_id]" ).append("\n"); 
		query.append("           ,SYSDATE" ).append("\n"); 
		query.append("           ,@[upd_usr_id]" ).append("\n"); 
		query.append("           ,SYSDATE" ).append("\n"); 
		query.append("FROM   CGM_EQ_LOT A,  CGM_EQUIPMENT C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("    AND   A.EQ_LOT_NO  = C.EQ_LOT_NO" ).append("\n"); 
		query.append("    AND   A.AGMT_OFC_CTY_CD   = C.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("    AND   A.AGMT_SEQ  = C.AGMT_SEQ" ).append("\n"); 
		query.append("    AND   A.AGMT_VER_NO   = C.AGMT_VER_NO" ).append("\n"); 
		query.append("    AND C.AGMT_LSTM_CD = 'OW'" ).append("\n"); 
		query.append("    AND C.EQ_NO BETWEEN @[lot_eq_pfx_cd] || @[fm_ser_no] || '0'  AND @[lot_eq_pfx_cd] || @[to_ser_no] ||'9' " ).append("\n"); 
		query.append("    AND NOT EXISTS(SELECT EQ_NO FROM MNR_EQ_STS WHERE EQ_NO=C.EQ_NO) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}