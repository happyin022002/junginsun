/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTAuditDBDAOAGTCommTobeApprovedUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.22
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.10.22 박성진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOAGTCommTobeApprovedUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * (ESM_AGT_0036) Agent Commission Approval 를 Confirm 한다.
	  * </pre>
	  */
	public AGTAuditDBDAOAGTCommTobeApprovedUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_apro_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_apro_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_apro_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
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
		params.put("scn_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOAGTCommTobeApprovedUSQL").append("\n"); 
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
		query.append("UPDATE AGT_AGN_COMM" ).append("\n"); 
		query.append("SET COMM_PROC_STS_CD  = 'AS'," ).append("\n"); 
		query.append("COMM_PROC_STS_RSN = 'Approval OK!'," ).append("\n"); 
		query.append("COMM_APRO_NO      = @[s_apro_no]," ).append("\n"); 
		query.append("AC_APRO_USR_ID    = @[ac_apro_usr_id]," ).append("\n"); 
		query.append("AC_APRO_DT        = TO_DATE (@[ac_apro_dt], 'YYYYMMDDHH24MISS')," ).append("\n"); 
		query.append("UPD_USR_ID        = @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT            = SYSDATE" ).append("\n"); 
		query.append("WHERE AC_IF_DT         IS NULL" ).append("\n"); 
		query.append("AND AC_APRO_DT       IS NULL" ).append("\n"); 
		query.append("AND AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("( @[scn_id]	= 'AGTCOMM'" ).append("\n"); 
		query.append("AND	AC_TP_CD <>	'T'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("( @[scn_id] = 'OTHER'" ).append("\n"); 
		query.append("AND AC_TP_CD =	'T'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") --scnId" ).append("\n"); 
		query.append("#if (${scn_id} == 'OTHER')" ).append("\n"); 
		query.append("#if (${exp_type} == 'G')" ).append("\n"); 
		query.append("AND	COMM_STND_COST_CD NOT IN ('512692','512693')	--comm_stnd_cost_cd(General	or General Exception)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND	COMM_STND_COST_CD IN ('512692','512693')	--comm_stnd_cost_cd(General	or General Exception)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND COMM_PROC_STS_CD" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("'RS','RM'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("BKG_NO, AGN_CD, IO_BND_CD, AC_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("${bkg_no}" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}