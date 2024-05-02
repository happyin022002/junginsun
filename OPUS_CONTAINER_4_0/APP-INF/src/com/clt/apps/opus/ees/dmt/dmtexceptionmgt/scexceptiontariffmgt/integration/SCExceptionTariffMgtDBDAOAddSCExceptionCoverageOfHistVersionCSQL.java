/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SCExceptionTariffMgtDBDAOAddSCExceptionCoverageOfHistVersionCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCExceptionTariffMgtDBDAOAddSCExceptionCoverageOfHistVersionCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/C Exception Tariff History 에서 선택한 버전의 모든 S/C Exception Tariff Coverage 정보를 현재 버전으로 생성하는 쿼리
	  * </pre>
	  */
	public SCExceptionTariffMgtDBDAOAddSCExceptionCoverageOfHistVersionCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_expt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hist_prop_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_expt_hist_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : SCExceptionTariffMgtDBDAOAddSCExceptionCoverageOfHistVersionCSQL").append("\n"); 
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
		query.append("INSERT INTO DMT_SC_EXPT_CVRG (" ).append("\n"); 
		query.append("    PROP_NO, SC_EXPT_VER_SEQ, SC_EXPT_GRP_SEQ, CVRG_SEQ, CNT_CD, RGN_CD, STE_CD, LOC_CD, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT	@[prop_no]" ).append("\n"); 
		query.append("	,	@[sc_expt_ver_seq]" ).append("\n"); 
		query.append("	,	SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("	,	CVRG_SEQ" ).append("\n"); 
		query.append("	,	CNT_CD" ).append("\n"); 
		query.append("	,	RGN_CD" ).append("\n"); 
		query.append("	,	STE_CD" ).append("\n"); 
		query.append("	,	LOC_CD" ).append("\n"); 
		query.append("	,	@[cre_usr_id]" ).append("\n"); 
		query.append("	,	SYSDATE" ).append("\n"); 
		query.append("	,	@[cre_usr_id]" ).append("\n"); 
		query.append("	,	SYSDATE" ).append("\n"); 
		query.append("FROM	DMT_SC_EXPT_CVRG" ).append("\n"); 
		query.append("WHERE	PROP_NO 		= @[hist_prop_no]" ).append("\n"); 
		query.append("	AND	SC_EXPT_VER_SEQ = @[sc_expt_hist_ver_seq]" ).append("\n"); 

	}
}