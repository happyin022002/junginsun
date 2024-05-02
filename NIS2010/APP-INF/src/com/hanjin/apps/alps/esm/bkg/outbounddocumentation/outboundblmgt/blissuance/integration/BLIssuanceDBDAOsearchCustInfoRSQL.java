/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchCustInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.20
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.20 
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

public class BLIssuanceDBDAOsearchCustInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCustInfo
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchCustInfoRSQL(){
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
		query.append("FileName : BLIssuanceDBDAOsearchCustInfoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	CUS.BKG_NO, " ).append("\n"); 
		query.append("	DECODE(CUS.BKG_CUST_TP_CD, 'S', 'SHPR', 'FWDR') as CUST_TP, " ).append("\n"); 
		query.append("	CUS.CUST_CNT_CD||DECODE(LPAD(CUS.CUST_SEQ, 6, 0), '000000', '', LPAD(CUST_SEQ, 6, 0)) as CUST_CD, " ).append("\n"); 
		query.append("	CUS.CUST_NM," ).append("\n"); 
		query.append("	ISS.WBL_EML" ).append("\n"); 
		query.append("FROM BKG_CUSTOMER CUS" ).append("\n"); 
		query.append("     ,BKG_BL_ISS ISS" ).append("\n"); 
		query.append("WHERE CUS.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("  AND CUS.BKG_NO = ISS.BKG_NO" ).append("\n"); 
		query.append("  AND CUS.BKG_CUST_TP_CD IN ('S', 'F')" ).append("\n"); 

	}
}