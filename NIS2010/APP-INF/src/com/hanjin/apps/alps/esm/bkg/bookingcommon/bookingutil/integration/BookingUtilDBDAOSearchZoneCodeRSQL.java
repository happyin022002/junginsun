/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingUtilDBDAOSearchZoneCodeRSQL.java
*@FileTitle : User Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.26 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchZoneCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * zone code조회
	  * </pre>
	  */
	public BookingUtilDBDAOSearchZoneCodeRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("ZN_CD" ).append("\n"); 
		query.append(",	ZN_NM" ).append("\n"); 
		query.append(",	REP_ZN_FLG" ).append("\n"); 
		query.append(",	REP_YD_CD" ).append("\n"); 
		query.append(",	TZTM_HRS" ).append("\n"); 
		query.append(",	CGO_HNDL_TM_HRS" ).append("\n"); 
		query.append(",	LOC_CD" ).append("\n"); 
		query.append(",	LNK_DIST" ).append("\n"); 
		query.append(",	DIST_UT_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	DELT_FLG" ).append("\n"); 
		query.append(",	EAI_EVNT_DT" ).append("\n"); 
		query.append("FROM MDM_ZONE" ).append("\n"); 
		query.append("WHERE	ZN_CD = @[zn_cd]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.bookingcommon.bookingutil.integration ").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchZoneCodeRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}