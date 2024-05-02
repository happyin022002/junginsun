/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BookingUtilDBDDAOsearchCstmsCdConvRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.18
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2011.02.18 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDDAOsearchCstmsCdConvRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingUtilDBDDAOsearchCstmsCdConvRSQL
	  * </pre>
	  */
	public BookingUtilDBDDAOsearchCstmsCdConvRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_div_id_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_div_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDDAOsearchCstmsCdConvRSQL").append("\n"); 
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
		query.append("/* BkgCstmsCdConvCtnt VO */" ).append("\n"); 
		query.append("SELECT *" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append(" WHERE CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("   AND CSTMS_DIV_ID = @[cstms_div_id]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${cstms_div_id_seq} != '') " ).append("\n"); 
		query.append("    AND CSTMS_DIV_ID_SEQ = @[cstms_div_id_seq]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   AND DELT_FLG ='N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY CSTMS_DIV_ID_SEQ" ).append("\n"); 

	}
}