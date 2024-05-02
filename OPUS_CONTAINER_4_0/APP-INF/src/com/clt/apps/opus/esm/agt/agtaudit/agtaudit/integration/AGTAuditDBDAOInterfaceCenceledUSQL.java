/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGTAuditDBDAOInterfaceCenceledUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.26
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOInterfaceCenceledUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InterfaceCenceled
	  * </pre>
	  */
	public AGTAuditDBDAOInterfaceCenceledUSQL(){
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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : AGTAuditDBDAOInterfaceCenceledUSQL").append("\n"); 
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
		query.append("SET COMM_PROC_STS_CD   = 'IC'," ).append("\n"); 
		query.append("COMM_PROC_STS_RSN  = 'Interface Cancel!'," ).append("\n"); 
		query.append("ACCL_FLG           = 'N'," ).append("\n"); 
		query.append("AC_IF_USR_ID       = NULL," ).append("\n"); 
		query.append("AC_IF_DT           = NULL," ).append("\n"); 
		query.append("AC_RQST_USR_ID     = NULL," ).append("\n"); 
		query.append("AC_RQST_USR_EML    = NULL," ).append("\n"); 
		query.append("AC_RQST_DT         = NULL," ).append("\n"); 
		query.append("COMM_APRO_NO       = NULL," ).append("\n"); 
		query.append("AC_APRO_USR_ID     = NULL," ).append("\n"); 
		query.append("AC_APRO_DT         = NULL," ).append("\n"); 
		query.append("ASA_NO             = NULL," ).append("\n"); 
		query.append("CSR_NO             = NULL," ).append("\n"); 
		query.append("INV_TAX_RT         = NULL," ).append("\n"); 
		query.append("UPD_USR_ID         = @[usr_id]," ).append("\n"); 
		query.append("UPD_DT             = SYSDATE" ).append("\n"); 
		query.append("WHERE BKG_NO             = @[bkg_no]" ).append("\n"); 
		query.append("AND AGN_CD             = @[agn_cd]" ).append("\n"); 
		query.append("AND IO_BND_CD          = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND AC_TP_CD           = @[ac_tp_cd]" ).append("\n"); 
		query.append("AND AC_SEQ             = @[ac_seq]" ).append("\n"); 

	}
}