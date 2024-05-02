/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UnmatchBLDBDAOAddCompareBkgRevUmchBkgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.29
*@LastModifier : 류선우
*@LastVersion : 1.0
* 2010.04.29 류선우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Sun Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOAddCompareBkgRevUmchBkgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addCompareBkgRevUmchBkg
	  * </pre>
	  */
	public UnmatchBLDBDAOAddCompareBkgRevUmchBkgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_aud_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_aud_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_umch_bkg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_corr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOAddCompareBkgRevUmchBkgCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_REV_UMCH_BKG" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  BKG_NO            ," ).append("\n"); 
		query.append("  UMCH_BKG_SEQ      ," ).append("\n"); 
		query.append("  BKG_CORR_NO       ," ).append("\n"); 
		query.append("  REV_AUD_STS_CD    ," ).append("\n"); 
		query.append("  N1ST_UMCH_FND_DT  ," ).append("\n"); 
		query.append("  LST_UMCH_FND_DT   ," ).append("\n"); 
		query.append("  REV_AUD_TP_CD     ," ).append("\n"); 
		query.append("  UMCH_RSN_RMK      ," ).append("\n"); 
		query.append("  RGN_GRP_AVC_RMK   ," ).append("\n"); 
		query.append("  CRE_USR_ID        ," ).append("\n"); 
		query.append("  CRE_DT            ," ).append("\n"); 
		query.append("  UPD_USR_ID        ," ).append("\n"); 
		query.append("  UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  @[bkg_no]         ," ).append("\n"); 
		query.append("        TO_NUMBER(@[max_umch_bkg_seq])  ," ).append("\n"); 
		query.append("        @[bkg_corr_no]    ," ).append("\n"); 
		query.append("        @[rev_aud_sts_cd] ," ).append("\n"); 
		query.append("        NVL(( SELECT N1ST_UMCH_FND_DT FROM BKG_REV_UMCH_BKG WHERE BKG_NO = @[bkg_no] AND UMCH_BKG_SEQ = @[max_umch_bkg_seq] - 1 AND REV_AUD_STS_CD = 'U' ), SYSDATE)  ," ).append("\n"); 
		query.append("        SYSDATE           ," ).append("\n"); 
		query.append("        @[rev_aud_tp_cd]  ," ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("        WHEN EXISTS ( SELECT 'X' FROM BKG_REV_UMCH_BKG WHERE BKG_NO = @[bkg_no] AND UMCH_BKG_SEQ = @[max_umch_bkg_seq] - 1 AND REV_AUD_STS_CD = 'U' )" ).append("\n"); 
		query.append("          THEN  ( SELECT UMCH_RSN_RMK FROM BKG_REV_UMCH_BKG WHERE BKG_NO = @[bkg_no] AND UMCH_BKG_SEQ = @[max_umch_bkg_seq] - 1 )" ).append("\n"); 
		query.append("        ELSE    ( SELECT RT_INTER_RMK FROM BKG_RATE WHERE BKG_NO = @[bkg_no] )" ).append("\n"); 
		query.append("        END               ," ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("        WHEN EXISTS ( SELECT 'X' FROM BKG_REV_UMCH_BKG WHERE BKG_NO = @[bkg_no] AND UMCH_BKG_SEQ = @[max_umch_bkg_seq] - 1 AND REV_AUD_STS_CD = 'U' )" ).append("\n"); 
		query.append("          THEN  ( SELECT RGN_GRP_AVC_RMK FROM BKG_REV_UMCH_BKG WHERE BKG_NO = @[bkg_no] AND UMCH_BKG_SEQ = @[max_umch_bkg_seq] - 1 )" ).append("\n"); 
		query.append("        ELSE    NULL" ).append("\n"); 
		query.append("        END               ," ).append("\n"); 
		query.append("        @[cre_usr_id]     ," ).append("\n"); 
		query.append("        SYSDATE           ," ).append("\n"); 
		query.append("        @[cre_usr_id]     ," ).append("\n"); 
		query.append("        SYSDATE" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 

	}
}