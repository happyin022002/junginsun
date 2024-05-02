/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : BookingUtilDBDAOSearchIdaSacMstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.28
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.07.28 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchIdaSacMstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingUtilDBDAOSearchIdaSacMstRSQL
	  * </pre>
	  */
	public BookingUtilDBDAOSearchIdaSacMstRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_sac_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchIdaSacMstRSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append("	 a.IDA_SAC_CD" ).append("\n"); 
		query.append("	, a.IDA_SAC_NM" ).append("\n"); 
		query.append("	, a.IDA_SAC_TP_CD" ).append("\n"); 
		query.append("	, a.PRNT_IDA_SAC_CD" ).append("\n"); 
		query.append("	, a.DELT_FLG" ).append("\n"); 
		query.append("	, a.CRE_DT" ).append("\n"); 
		query.append("	, a.CRE_USR_ID" ).append("\n"); 
		query.append("	, a.UPD_DT" ).append("\n"); 
		query.append("	, a.UPD_USR_ID " ).append("\n"); 
		query.append("from BKG_IDA_SAC_MST a" ).append("\n"); 
		query.append("where IDA_SAC_CD = @[ida_sac_cd] " ).append("\n"); 

	}
}