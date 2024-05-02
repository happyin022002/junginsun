/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MarineTermainalInvoiceManageDBDAOCheckTerminalInvoiceStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.15
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.12.15 박재흥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTermainalInvoiceManageDBDAOCheckTerminalInvoiceStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckTerminalInvoiceStatus
	  * </pre>
	  */
	public MarineTermainalInvoiceManageDBDAOCheckTerminalInvoiceStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration ").append("\n"); 
		query.append("FileName : MarineTermainalInvoiceManageDBDAOCheckTerminalInvoiceStatusRSQL").append("\n"); 
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
		query.append("SELECT tml_inv_sts_cd," ).append("\n"); 
		query.append("tml_inv_rjct_sts_cd" ).append("\n"); 
		query.append("FROM  tes_tml_so_hdr" ).append("\n"); 
		query.append("WHERE vndr_seq = @[vndr_seq]" ).append("\n"); 
		query.append("AND   inv_no   = @[inv_no]" ).append("\n"); 
		query.append("AND   NVL(delt_flg,'N')   <> 'Y'" ).append("\n"); 

	}
}