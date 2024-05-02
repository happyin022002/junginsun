/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : UnmatchBLDBDAOAddAuditRmkByEqSubErrListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.27
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOAddAuditRmkByEqSubErrListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Audit Remark 정보를 저장한다.
	  * </pre>
	  */
	public UnmatchBLDBDAOAddAuditRmkByEqSubErrListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_grp_avc_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("umch_rsn_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOAddAuditRmkByEqSubErrListCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_REV_AUD_RSLT(" ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append(",	BKG_REV_AUD_TP_CD" ).append("\n"); 
		query.append(",	BKG_REV_AUD_SEQ" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	UMCH_RSN_RMK" ).append("\n"); 
		query.append(",	RGN_GRP_AVC_RMK" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")VALUES (" ).append("\n"); 
		query.append("	@[bkg_no]" ).append("\n"); 
		query.append(",	'E'" ).append("\n"); 
		query.append(",	 (" ).append("\n"); 
		query.append("       SELECT NVL(MAX(BKG_REV_AUD_SEQ), 0) " ).append("\n"); 
		query.append("       FROM   BKG_REV_AUD_RSLT" ).append("\n"); 
		query.append("       WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("       AND BKG_REV_AUD_TP_CD ='E'" ).append("\n"); 
		query.append("      ) +1 " ).append("\n"); 
		query.append(",	@[ctrt_cntr_tpsz_cd]" ).append("\n"); 
		query.append(",	@[umch_rsn_rmk]" ).append("\n"); 
		query.append(",	@[rgn_grp_avc_rmk]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}