/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchRefNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.09 
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

public class BLIssuanceDBDAOSearchRefNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLIssuanceDBDAOSearchRefNo
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchRefNoRSQL(){
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
		query.append("FileName : BLIssuanceDBDAOSearchRefNoRSQL").append("\n"); 
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
		query.append("SELECT '{REF_INFO' ||CHR(10) || " ).append("\n"); 
		query.append("       'REF_TP_CD:'|| DECODE(BKG_REF_TP_CD,'BKPO', '17','')||CHR(10) || " ).append("\n"); 
		query.append("       'REF_NO:' || CUST_REF_NO_CTNT ||CHR(10) || " ).append("\n"); 
		query.append("       '}REF_INFO'  ||CHR(10)" ).append("\n"); 
		query.append("FROM   BKG_BOOKING A" ).append("\n"); 
		query.append("      ,BKG_REFERENCE B " ).append("\n"); 
		query.append("WHERE A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND B.BKG_REF_TP_CD IN ('BKPO')" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT '{REF_INFO' ||CHR(10) || " ).append("\n"); 
		query.append("       'REF_TP_CD:'|| '28' ||CHR(10) || " ).append("\n"); 
		query.append("       'REF_NO:' || HBL_NO ||CHR(10) || " ).append("\n"); 
		query.append("       '}REF_INFO'  ||CHR(10)" ).append("\n"); 
		query.append("FROM   BKG_BOOKING A" ).append("\n"); 
		query.append("      ,BKG_HBL B  " ).append("\n"); 
		query.append("WHERE A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("AND A.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}