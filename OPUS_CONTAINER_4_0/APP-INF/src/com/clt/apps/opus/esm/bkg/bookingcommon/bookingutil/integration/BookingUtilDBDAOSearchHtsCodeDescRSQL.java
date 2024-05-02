/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingUtilDBDAOSearchHtsCodeDescRSQL.java
*@FileTitle : User Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.27 김기종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchHtsCodeDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * HTS Code 체크
	  * </pre>
	  */
	public BookingUtilDBDAOSearchHtsCodeDescRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hamo_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("HAMO_TRF_CD" ).append("\n"); 
		query.append(",	HAMO_CD_DESC" ).append("\n"); 
		query.append(",	FDA_DECL_FLG" ).append("\n"); 
		query.append(",	DELT_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append("FROM BKG_HAMO_TRF" ).append("\n"); 
		query.append("WHERE	HAMO_TRF_CD = @[hamo_trf_cd]" ).append("\n"); 
		query.append("AND	DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND ROWNUM =1" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchHtsCodeDescRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}