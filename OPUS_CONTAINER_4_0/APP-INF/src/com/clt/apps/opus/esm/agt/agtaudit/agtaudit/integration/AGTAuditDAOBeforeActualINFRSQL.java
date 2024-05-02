/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTAuditDAOBeforeActualINFRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.18 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDAOBeforeActualINFRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BeforeActualINF
	  * </pre>
	  */
	public AGTAuditDAOBeforeActualINFRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDAOBeforeActualINFRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("ACT_PRE_COMM_AMT," ).append("\n"); 
		query.append("ACT_COMM_AMT," ).append("\n"); 
		query.append("ACT_IF_COMM_AMT," ).append("\n"); 
		query.append("ACT_PRE_LOCL_COMM_AMT," ).append("\n"); 
		query.append("ACT_LOCL_COMM_AMT," ).append("\n"); 
		query.append("ACT_IF_LOCL_COMM_AMT" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM" ).append("\n"); 
		query.append("WHERE BKG_NO    = @[bkg_no]" ).append("\n"); 
		query.append("AND AGN_CD    = @[agn_cd]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND AC_TP_CD  = @[ac_tp_cd]" ).append("\n"); 
		query.append("AND AC_SEQ    = @[ac_seq]" ).append("\n"); 

	}
}