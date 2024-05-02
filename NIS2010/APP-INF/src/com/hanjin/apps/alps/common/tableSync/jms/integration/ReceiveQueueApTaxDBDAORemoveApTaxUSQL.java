/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReceiveQueueApTaxDBDAORemoveApTaxUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.10.20 박재흥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.tableSync.jms.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueApTaxDBDAORemoveApTaxUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RemoveApTax
	  * </pre>
	  */
	public ReceiveQueueApTaxDBDAORemoveApTaxUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_tax_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tax_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.common.tableSync.jms.integration ").append("\n"); 
		query.append("FileName : ReceiveQueueApTaxDBDAORemoveApTaxUSQL").append("\n"); 
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
		query.append("UPDATE ap_tax SET aval_flg = 'N'" ).append("\n"); 
		query.append("WHERE 	ap_tax_nm  = HJSEAI_PKG.h_decode(@[ap_tax_nm], 'UTF8' ,'UTF8')" ).append("\n"); 
		query.append("AND	tax_no    = @[tax_no]" ).append("\n"); 
		query.append("AND 	eai_evnt_dt <= to_date(@[eai_evnt_dt],'yyyymmddhh24miss')" ).append("\n"); 

	}
}