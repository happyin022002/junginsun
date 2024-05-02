/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOAddCancelCommentHistoryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAExceptionTariffMgtDBDAOAddCancelCommentHistoryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 최종버전이 Approval 될 경우, 만일 이전버전에 Approval 된 데이터가 있다면, 그 버전에 Cancel Comment 를 추가해주는 쿼리문
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOAddCancelCommentHistoryCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_mapg_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rfa_expt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAOAddCancelCommentHistoryCSQL").append("\n"); 
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
		query.append("INSERT INTO DMT_RFA_EXPT_TRF_PROG (" ).append("\n"); 
		query.append("    RFA_EXPT_DAR_NO, RFA_EXPT_MAPG_SEQ, RFA_EXPT_VER_SEQ, PROG_SEQ, DMDT_EXPT_RQST_STS_CD, PROG_RMK, PROG_DT, PROG_USR_ID, " ).append("\n"); 
		query.append("    PROG_OFC_CD, CRE_USR_ID, CRE_DT, CRE_OFC_CD, UPD_USR_ID, UPD_DT, UPD_OFC_CD" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("     RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append(",    RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append(",    RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",    (" ).append("\n"); 
		query.append("        SELECT    NVL(MAX(PROG_SEQ), 0) + 1" ).append("\n"); 
		query.append("        FROM    DMT_RFA_EXPT_TRF_PROG" ).append("\n"); 
		query.append("        WHERE    RFA_EXPT_DAR_NO = @[rfa_expt_dar_no]" ).append("\n"); 
		query.append("            AND    RFA_EXPT_MAPG_SEQ = @[rfa_expt_mapg_seq]" ).append("\n"); 
		query.append("            AND RFA_EXPT_VER_SEQ = A.RFA_EXPT_VER_SEQ " ).append("\n"); 
		query.append("    ) PROG_SEQ" ).append("\n"); 
		query.append(",   'C' DMDT_EXPT_RQST_STS_CD" ).append("\n"); 
		query.append(",   '' PROG_RMK" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",   @[cre_usr_id]" ).append("\n"); 
		query.append(",   @[cre_ofc_cd]" ).append("\n"); 
		query.append(",   @[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[cre_ofc_cd]" ).append("\n"); 
		query.append(",   @[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[cre_ofc_cd]" ).append("\n"); 
		query.append("FROM	DMT_RFA_EXPT_TRF A" ).append("\n"); 
		query.append("WHERE	RFA_EXPT_DAR_NO = @[rfa_expt_dar_no]" ).append("\n"); 
		query.append("	AND	RFA_EXPT_MAPG_SEQ = @[rfa_expt_mapg_seq]" ).append("\n"); 
		query.append("	AND RFA_EXPT_VER_SEQ < @[rfa_expt_ver_seq]" ).append("\n"); 
		query.append("	AND DMDT_EXPT_RQST_STS_CD = 'A'" ).append("\n"); 

	}
}