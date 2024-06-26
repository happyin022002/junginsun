/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SCDurationProposalDBDAOPriSpScpDurTermsVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.14
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2014.11.14 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHojin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCDurationProposalDBDAOPriSpScpDurTermsVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AMEND SEQ 0일 경우 사용자가 FILING DATE로 UPDATE
	  * </pre>
	  */
	public SCDurationProposalDBDAOPriSpScpDurTermsVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.integration").append("\n"); 
		query.append("FileName : SCDurationProposalDBDAOPriSpScpDurTermsVOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_SP_SCP_DUR A" ).append("\n"); 
		query.append("   SET A.CTRT_EFF_DT   = TO_DATE(@[file_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID    = @[upd_usr_id]" ).append("\n"); 
		query.append("      ,A.UPD_DT        = SYSDATE " ).append("\n"); 
		query.append("WHERE  A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND    A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND (  @[amdt_seq] = 0" ).append("\n"); 
		query.append("        OR  NOT EXISTS" ).append("\n"); 
		query.append("            (   SELECT  1 " ).append("\n"); 
		query.append("                FROM    PRI_SP_SCP_MN M" ).append("\n"); 
		query.append("                WHERE   M.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("                AND     M.AMDT_SEQ < @[amdt_seq]" ).append("\n"); 
		query.append("                AND     M.SVC_SCP_CD = A.SVC_SCP_CD )" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}