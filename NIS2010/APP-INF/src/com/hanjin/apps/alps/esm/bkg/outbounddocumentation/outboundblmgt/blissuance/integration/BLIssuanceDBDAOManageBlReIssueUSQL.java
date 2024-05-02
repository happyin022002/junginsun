/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLIssuanceDBDAOManageBlReIssueUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.09.03 이진서
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jin Seo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOManageBlReIssueUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ManageBlReIssue
	  * </pre>
	  */
	public BLIssuanceDBDAOManageBlReIssueUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_evnt_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_riss_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("riss_cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("riss_rdem_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("his_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("riss_rsn",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("riss_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOManageBlReIssueUSQL").append("\n"); 
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
		query.append("#if (${sql_type} == 'count')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT COUNT(BKG_NO) FROM BKG_DOC_ISS_HIS WHERE BKG_NO= @[bkg_no] AND HIS_SEQ= @[his_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${sql_type} == 'insert')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("INSERT INTO BKG_DOC_ISS_HIS (" ).append("\n"); 
		query.append("BKG_NO, HIS_SEQ, BKG_EVNT_KND_CD," ).append("\n"); 
		query.append("RISS_FLG, BL_RISS_RSN_CD, RISS_RSN," ).append("\n"); 
		query.append("RISS_CFM_FLG, RISS_RDEM_FLG, CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("@[bkg_no], (SELECT  NVL(MAX(HIS_SEQ),0)+1 AS SEQ FROM BKG_DOC_ISS_HIS WHERE BKG_NO = @[bkg_no]), @[bkg_evnt_knd_cd]," ).append("\n"); 
		query.append("@[riss_flg], @[bl_riss_rsn_cd], @[riss_rsn]," ).append("\n"); 
		query.append("@[riss_cfm_flg], @[riss_rdem_flg], @[cre_usr_id]," ).append("\n"); 
		query.append("sysdate, @[upd_usr_id], sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${sql_type} == 'update')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE BKG_DOC_ISS_HIS" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("BL_RISS_RSN_CD   = @[bl_riss_rsn_cd]" ).append("\n"); 
		query.append(",RISS_RSN        = @[riss_rsn]" ).append("\n"); 
		query.append(",UPD_USR_ID      = @[upd_usr_id]" ).append("\n"); 
		query.append(",UPD_DT          = sysdate" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("BKG_NO= @[bkg_no] AND HIS_SEQ= @[his_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}