/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ARInvoiceExRateMgtDBDAOsearchARInvoiceExist2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceExRateMgtDBDAOsearchARInvoiceExist2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ARInvoiceExRateMgtDBDAO::searchARInvoiceExist2 ( exRateVo )
	  * INV AR CHARGE 테이블에서 해당 환율이 반영된 데이터가 존재하는지 CHECK.
	  * </pre>
	  */
	public ARInvoiceExRateMgtDBDAOsearchARInvoiceExist2RSQL(){
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
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceExRateMgtDBDAOsearchARInvoiceExist2RSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) CNT     " ).append("\n"); 
		query.append("  FROM INV_AR_CHG" ).append("\n"); 
		query.append(" WHERE AR_IF_NO IN (SELECT AR_IF_NO" ).append("\n"); 
		query.append("                      FROM INV_AR_MN" ).append("\n"); 
		query.append("                     WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                       AND SKD_VOY_NO  = @[skd_voy_no]" ).append("\n"); 
		query.append("                       AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                       AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("                       AND AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("                    #if($portScopeArr.size() > 0) " ).append("\n"); 
		query.append("                       AND (DECODE(@[io_bnd_cd],'O',POL_CD,'I',POD_CD),SVC_SCP_CD) IN (" ).append("\n"); 
		query.append("	    			#foreach( ${key} in ${portScopeArr})" ).append("\n"); 
		query.append("		      			#if($velocityCount == 1)" ).append("\n"); 
		query.append(" 			     			('${key.portCd}', '${key.svcScpCd}')" ).append("\n"); 
		query.append("		      			#else " ).append("\n"); 
		query.append("							, ('${key.portCd}', '${key.svcScpCd}')" ).append("\n"); 
		query.append("						#end " ).append("\n"); 
		query.append("	       			#end " ).append("\n"); 
		query.append("				             )" ).append("\n"); 
		query.append("        	        )" ).append("\n"); 
		query.append("      	            #end" ).append("\n"); 

	}
}