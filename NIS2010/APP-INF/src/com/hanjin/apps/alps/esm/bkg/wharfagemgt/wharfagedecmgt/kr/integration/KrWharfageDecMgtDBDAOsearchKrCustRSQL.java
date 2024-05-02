/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchKrCustRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.24
*@LastModifier : 민동진
*@LastVersion : 1.0
* 2009.11.24 민동진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min, DongJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOsearchKrCustRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchKrCustRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchKrCustRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("A.CUST_NM" ).append("\n"); 
		query.append(",A.CUST_ADDR" ).append("\n"); 
		query.append(",A.CUST_TP_CD" ).append("\n"); 
		query.append(",A.BKG_CUST_TP_CD" ).append("\n"); 
		query.append(", CASE WHEN A.BKG_CUST_TP_CD = 'S' THEN '1'" ).append("\n"); 
		query.append("WHEN A.BKG_CUST_TP_CD = 'F' THEN '2'" ).append("\n"); 
		query.append("WHEN A.BKG_CUST_TP_CD = 'C' THEN '3'" ).append("\n"); 
		query.append("WHEN A.BKG_CUST_TP_CD = 'N' THEN '4'" ).append("\n"); 
		query.append("WHEN A.BKG_CUST_TP_CD = 'A' THEN '5'" ).append("\n"); 
		query.append("ELSE '9'" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("FROM BKG_CUSTOMER A, BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("AND B.BL_NO  = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("ORDER BY (CASE WHEN A.BKG_CUST_TP_CD = 'S' THEN '1'" ).append("\n"); 
		query.append("WHEN A.BKG_CUST_TP_CD = 'F' THEN '2'" ).append("\n"); 
		query.append("WHEN A.BKG_CUST_TP_CD = 'C' THEN '3'" ).append("\n"); 
		query.append("WHEN A.BKG_CUST_TP_CD = 'N' THEN '4'" ).append("\n"); 
		query.append("WHEN A.BKG_CUST_TP_CD = 'A' THEN '5'" ).append("\n"); 
		query.append("ELSE '9'" ).append("\n"); 
		query.append("END)" ).append("\n"); 

	}
}