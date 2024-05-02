/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableInvoiceMigrationDBDAOSearchVVDSaDtByVslVoyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableInvoiceMigrationDBDAOSearchVVDSaDtByVslVoyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search VVD SaDt By Vsl Voy
	  * </pre>
	  */
	public AccountReceivableInvoiceMigrationDBDAOSearchVVDSaDtByVslVoyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration").append("\n"); 
		query.append("FileName : AccountReceivableInvoiceMigrationDBDAOSearchVVDSaDtByVslVoyRSQL").append("\n"); 
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
		query.append("SELECT VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD," ).append("\n"); 
		query.append("       DECODE(@[io_bnd_cd], 'O', TO_CHAR(VPS_ETD_DT, 'YYYYMMDD'), TO_CHAR(VPS_ETA_DT, 'YYYYMMDD')) SAIL_ARR_DT" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#if (${div_cd} == 'A')" ).append("\n"); 
		query.append("  AND SKD_VOY_NO = (SELECT MAX(SKD_VOY_NO)" ).append("\n"); 
		query.append("                      FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                     WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                       AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                       AND VPS_PORT_CD = @[port_cd])" ).append("\n"); 
		query.append("  AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("  AND ROWNUM = 1" ).append("\n"); 

	}
}