/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingUtilDBDAOSearchScNoValidationCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.29
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2010.03.29 이진서
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jin Seo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchScNoValidationCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchScNoValidationCheck
	  * </pre>
	  */
	public BookingUtilDBDAOSearchScNoValidationCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("app_date",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration ").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchScNoValidationCheckRSQL").append("\n"); 
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
		query.append("MN.CONV_CFM_FLG AS OUTPUT_TEXT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRI_SP_HDR HD, PRI_SP_MN MN" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND HD.SC_NO =@[sc_no] /* SC_NO */" ).append("\n"); 
		query.append("AND HD.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("AND MN.PROP_STS_CD ='F'" ).append("\n"); 
		query.append("AND MN.AMDT_SEQ IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT AMDT_SEQ FROM PRI_SP_MN K WHERE K.PROP_NO = MN.PROP_NO AND PROP_STS_CD ='F'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND TO_DATE(@[app_date],'YYYYMMDD') /* Application Date*/" ).append("\n"); 
		query.append("BETWEEN  MN.EFF_DT AND MN.EXP_DT" ).append("\n"); 

	}
}