/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOsearchActalSailingArrivalDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.15
*@LastModifier : 
*@LastVersion : 1.0
* 2012.10.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOsearchActalSailingArrivalDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchActalSailingArrivalDate
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOsearchActalSailingArrivalDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOsearchActalSailingArrivalDateRSQL").append("\n"); 
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
		query.append("SELECT  CASE WHEN TO_DATE(@[sail_arr_dt],'YYYYMMDD') > NVL(DECODE(@[io_bnd_cd], 'O/B', ACT_DEP_DT, ACT_ARR_DT),TO_DATE('1900101','YYYYMMDD')) THEN @[sail_arr_dt]" ).append("\n"); 
		query.append("        ELSE TO_CHAR(DECODE(@[io_bnd_cd], 'O/B', ACT_DEP_DT, ACT_ARR_DT),'YYYYMMDD')" ).append("\n"); 
		query.append("        END ACT_SA_DATE " ).append("\n"); 
		query.append("  FROM   VSK_ACT_PORT_SKD" ).append("\n"); 
		query.append("  WHERE  VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("  AND    SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("  AND    SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("  AND    VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("  AND    ROWNUM =1" ).append("\n"); 
		query.append("  ORDER BY CLPT_IND_SEQ" ).append("\n"); 

	}
}