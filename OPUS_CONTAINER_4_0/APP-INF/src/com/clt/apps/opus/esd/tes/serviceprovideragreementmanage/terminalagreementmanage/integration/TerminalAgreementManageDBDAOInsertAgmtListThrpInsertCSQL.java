/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalAgreementManageDBDAOInsertAgmtListThrpInsertCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.08 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalAgreementManageDBDAOInsertAgmtListThrpInsertCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Throughtput Cost 정보 생성
	  * </pre>
	  */
	public TerminalAgreementManageDBDAOInsertAgmtListThrpInsertCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("thrp_lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("thrp_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration ").append("\n"); 
		query.append("FileName : TerminalAgreementManageDBDAOInsertAgmtListThrpInsertCSQL").append("\n"); 
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
		query.append("MERGE INTO TES_TML_AGMT_THRP_COST A" ).append("\n"); 
		query.append("USING" ).append("\n"); 
		query.append("(SELECT @[tml_agmt_ofc_cty_cd] tml_agmt_ofc_cty_cd" ).append("\n"); 
		query.append(", @[tml_agmt_seq] tml_agmt_seq" ).append("\n"); 
		query.append(", @[tml_agmt_ver_no] tml_agmt_ver_no" ).append("\n"); 
		query.append(", @[lgs_cost_cd] lgs_cost_cd" ).append("\n"); 
		query.append(", @[thrp_lgs_cost_cd] thrp_lgs_cost_cd" ).append("\n"); 
		query.append("FROM DUAL ) B" ).append("\n"); 
		query.append("ON" ).append("\n"); 
		query.append("(  		A.tml_agmt_ofc_cty_cd	= B.tml_agmt_ofc_cty_cd" ).append("\n"); 
		query.append("AND		A.tml_agmt_seq			= B.tml_agmt_seq" ).append("\n"); 
		query.append("AND		A.tml_agmt_ver_no		= B.tml_agmt_ver_no" ).append("\n"); 
		query.append("AND		A.lgs_cost_cd			= B.lgs_cost_cd" ).append("\n"); 
		query.append("AND		A.thrp_lgs_cost_cd		= B.thrp_lgs_cost_cd )" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT	( tml_agmt_ofc_cty_cd, tml_agmt_seq, tml_agmt_ver_no, thrp_seq, lgs_cost_cd," ).append("\n"); 
		query.append("thrp_lgs_cost_cd, cre_usr_id, cre_dt, upd_usr_id, upd_dt," ).append("\n"); 
		query.append("locl_cre_dt)" ).append("\n"); 
		query.append("VALUES	( @[tml_agmt_ofc_cty_cd], @[tml_agmt_seq], @[tml_agmt_ver_no], @[thrp_seq], @[lgs_cost_cd]," ).append("\n"); 
		query.append("@[thrp_lgs_cost_cd], @[cre_usr_id], SYSDATE, @[cre_usr_id], SYSDATE," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}