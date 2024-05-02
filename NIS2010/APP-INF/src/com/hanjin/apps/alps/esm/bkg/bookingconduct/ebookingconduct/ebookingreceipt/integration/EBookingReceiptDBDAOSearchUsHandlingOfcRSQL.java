/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchUsHandlingOfcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.07
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2014.11.07 Do Soon Choi
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do Soon Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOSearchUsHandlingOfcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EBookingReceiptDBDAOSearchUsHandlingOfc
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchUsHandlingOfcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOSearchUsHandlingOfcRSQL").append("\n"); 
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
		query.append("SELECT OFC_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT 1 RANK" ).append("\n"); 
		query.append("       ,HNDL_OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("  FROM BKG_HNDL_OFC_STUP" ).append("\n"); 
		query.append(" WHERE upper(@[cmdt_nm]) LIKE '%'||CMDT_NM||'%' " ).append("\n"); 
		query.append("   AND CMDT_NM IS NOT NULL" ).append("\n"); 
		query.append("   AND @[pol_cd] LIKE 'US%'" ).append("\n"); 
		query.append(" UNION" ).append("\n"); 
		query.append("SELECT 2 RANK" ).append("\n"); 
		query.append("       ,HNDL_OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("  FROM BKG_HNDL_OFC_STUP" ).append("\n"); 
		query.append(" WHERE POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("ORDER BY RANK" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM =1" ).append("\n"); 

	}
}