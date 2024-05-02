/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiFnlAta15RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchDblEdiFnlAta15RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLIssuanceDBDAOsearchDblEdiFnlAta15RSQL
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiFnlAta15RSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiFnlAta15RSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(MAX(ACT_DT), 'RRRRMMDDHH24MI', 'NLS_DATE_LANGUAGE=ENGLISH') AS DEL_ACT_ARRIVAL_DATE" ).append("\n"); 
		query.append("  FROM SCE_COP_HDR HDR" ).append("\n"); 
		query.append("      ,SCE_COP_DTL DTL" ).append("\n"); 
		query.append("      ,BKG_BOOKING BK" ).append("\n"); 
		query.append(" WHERE BK.BKG_NO = HDR.BKG_NO " ).append("\n"); 
		query.append("   AND HDR.COP_NO = DTL.COP_NO" ).append("\n"); 
		query.append("   AND DTL.NOD_CD = BK.DEL_NOD_CD" ).append("\n"); 
		query.append("   AND HDR.COP_STS_CD IN ('C','T','F')" ).append("\n"); 
		query.append("   AND (   DTL.ACT_CD LIKE 'FI__A_'" ).append("\n"); 
		query.append("        OR DTL.ACT_CD LIKE 'FU__U_') " ).append("\n"); 
		query.append("   AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}