/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiIbNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.01
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchDblEdiIbNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiIbNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiIbNoRSQL").append("\n"); 
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
		query.append("SELECT MAX(MST.XTER_SNDR_ID) EDI_SENDER, MAX(A.IB_NO) IB_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT MAX(DECODE(BKG_REF_TP_CD, 'ESRF', CUST_REF_NO_CTNT)) IB_NO" ).append("\n"); 
		query.append("        FROM   BKG_REFERENCE" ).append("\n"); 
		query.append("        WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        GROUP BY BKG_NO" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("WHERE MST.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND MST.XTER_RQST_NO = A.IB_NO" ).append("\n"); 
		query.append("GROUP BY MST.XTER_SNDR_ID" ).append("\n"); 

	}
}