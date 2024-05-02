/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PoolChassisDBDAODupChkPoolChassisInvoiceNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.22
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2011.03.22 최종혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.poolchassis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PoolChassisDBDAODupChkPoolChassisInvoiceNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice No에 대한 중복 체크
	  * </pre>
	  */
	public PoolChassisDBDAODupChkPoolChassisInvoiceNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("paymt_sp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.poolchassis.integration").append("\n"); 
		query.append("FileName : PoolChassisDBDAODupChkPoolChassisInvoiceNoRSQL").append("\n"); 
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
		query.append("SELECT COUNT(A.INV_NO) INV_FLAG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(	SELECT INV_NO" ).append("\n"); 
		query.append(",INV_VNDR_SEQ" ).append("\n"); 
		query.append("FROM TRS_TRSP_INV_WRK" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT INV_NO" ).append("\n"); 
		query.append(",INV_VNDR_SEQ" ).append("\n"); 
		query.append("FROM TRS_TRSP_RAIL_INV_WRK" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE INV_NO = @[inv_no]" ).append("\n"); 
		query.append("AND INV_VNDR_SEQ = @[paymt_sp_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}