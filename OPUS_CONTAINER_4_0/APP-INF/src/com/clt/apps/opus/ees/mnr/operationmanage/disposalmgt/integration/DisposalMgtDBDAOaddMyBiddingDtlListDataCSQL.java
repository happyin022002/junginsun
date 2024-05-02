/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DisposalMgtDBDAOaddMyBiddingDtlListDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOaddMyBiddingDtlListDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력 - EES_MNR_S304 화면에서 입력
	  * </pre>
	  */
	public DisposalMgtDBDAOaddMyBiddingDtlListDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("part_disp_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sp_ptal_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_disp_cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_disp_dtl_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mnr_disp_cfm_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("part_ut_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_disp_cfm_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOaddMyBiddingDtlListDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_DISP_BUYR_DTL_PART" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  DISP_NO" ).append("\n"); 
		query.append(", DISP_DTL_SEQ" ).append("\n"); 
		query.append(", MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append(", MNR_PRNR_SEQ " ).append("\n"); 
		query.append(", EQ_TPSZ_CD" ).append("\n"); 
		query.append(", DISP_QTY" ).append("\n"); 
		query.append(", DISP_CFM_QTY" ).append("\n"); 
		query.append(", PART_UT_AMT" ).append("\n"); 
		query.append(", MNR_DISP_CFM_STS_CD" ).append("\n"); 
		query.append(", MNR_DISP_CFM_DT" ).append("\n"); 
		query.append(", MNR_DISP_CFM_USR_ID" ).append("\n"); 
		query.append(", MNR_DISP_DTL_RMK" ).append("\n"); 
		query.append(", VNDR_BID_KNT" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", VNDR_BID_TMS" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  @[disp_no]" ).append("\n"); 
		query.append(", @[disp_dtl_seq]" ).append("\n"); 
		query.append(", (SELECT MNR_PRNR_CNT_CD " ).append("\n"); 
		query.append("     FROM MNR_PARTNER" ).append("\n"); 
		query.append("    WHERE MNR_GRP_TP_CD = 'DSP'" ).append("\n"); 
		query.append("      AND MNR_PRNR_STS_CD = 'C'" ).append("\n"); 
		query.append("      AND SP_PTAL_ID = @[sp_ptal_id])" ).append("\n"); 
		query.append(", (SELECT MNR_PRNR_SEQ " ).append("\n"); 
		query.append("     FROM MNR_PARTNER" ).append("\n"); 
		query.append("    WHERE MNR_GRP_TP_CD = 'DSP'" ).append("\n"); 
		query.append("      AND MNR_PRNR_STS_CD = 'C'" ).append("\n"); 
		query.append("      AND SP_PTAL_ID = @[sp_ptal_id])" ).append("\n"); 
		query.append(", @[eq_tpsz_cd]" ).append("\n"); 
		query.append(", DECODE(@[part_disp_qty],null,1,@[part_disp_qty])" ).append("\n"); 
		query.append(", 0" ).append("\n"); 
		query.append(", @[part_ut_amt]" ).append("\n"); 
		query.append(", @[mnr_disp_cfm_sts_cd]" ).append("\n"); 
		query.append(", @[mnr_disp_cfm_dt]" ).append("\n"); 
		query.append(", @[mnr_disp_cfm_usr_id]" ).append("\n"); 
		query.append(", @[mnr_disp_dtl_rmk]" ).append("\n"); 
		query.append(", 1" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[upd_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", SYSTIMESTAMP" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}