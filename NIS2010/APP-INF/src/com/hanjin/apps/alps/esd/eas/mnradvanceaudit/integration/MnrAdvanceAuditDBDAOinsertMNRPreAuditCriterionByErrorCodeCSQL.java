/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MnrAdvanceAuditDBDAOinsertMNRPreAuditCriterionByErrorCodeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.24
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2015.06.24 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Min Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MnrAdvanceAuditDBDAOinsertMNRPreAuditCriterionByErrorCodeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MNR Pre-Audit Criterion By Error Code 에서 새로운 Office Code 추가
	  * </pre>
	  */
	public MnrAdvanceAuditDBDAOinsertMNRPreAuditCriterionByErrorCodeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("i_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration").append("\n"); 
		query.append("FileName : MnrAdvanceAuditDBDAOinsertMNRPreAuditCriterionByErrorCodeCSQL").append("\n"); 
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
		query.append("INSERT INTO EAS_MNR_PRE_AUD_VRFY_CFG" ).append("\n"); 
		query.append("(AUD_OFC_CD, EXPN_AUD_MNR_VRFY_TP_CD, MNR_VRFY_TP_CD, MNR_VRFY_TP_AUD_FLG, VRFY_RMK, CRE_USR_ID, CRE_DT, UPD_OFC_CD, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("    SELECT @[i_ofc_cd]," ).append("\n"); 
		query.append("       INTG_CD_VAL_CTNT," ).append("\n"); 
		query.append("       MNR_CD_ID," ).append("\n"); 
		query.append("       NVL(C.MNR_VRFY_TP_AUD_FLG, 'N')," ).append("\n"); 
		query.append("       ''," ).append("\n"); 
		query.append("       @[cre_usr_id],  " ).append("\n"); 
		query.append("       sysdate, " ).append("\n"); 
		query.append("       @[ofc_cd]," ).append("\n"); 
		query.append("       @[upd_usr_id]," ).append("\n"); 
		query.append("       sysdate" ).append("\n"); 
		query.append("  FROM (SELECT B.INTG_CD_VAL_CTNT," ).append("\n"); 
		query.append("               A.MNR_CD_ID" ).append("\n"); 
		query.append("          FROM MNR_GEN_CD A," ).append("\n"); 
		query.append("               COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("         WHERE A.PRNT_CD_ID = 'CD00004'" ).append("\n"); 
		query.append("           AND B.INTG_CD_ID = 'CD03412'" ).append("\n"); 
		query.append("           AND A.MNR_CD_ID NOT IN ('SS', 'SL', 'OF') ) A, " ).append("\n"); 
		query.append("       EAS_MNR_PRE_AUD_VRFY_CFG C" ).append("\n"); 
		query.append(" WHERE C.EXPN_AUD_MNR_VRFY_TP_CD (+) = A.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("   AND C.MNR_VRFY_TP_CD (+)= A.MNR_CD_ID" ).append("\n"); 
		query.append("   AND C.AUD_OFC_CD (+)= MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(@[i_ofc_cd])" ).append("\n"); 

	}
}