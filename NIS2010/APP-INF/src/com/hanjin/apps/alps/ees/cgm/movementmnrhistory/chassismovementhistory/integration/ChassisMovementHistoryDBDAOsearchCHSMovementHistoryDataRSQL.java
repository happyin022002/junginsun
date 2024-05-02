/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ChassisMovementHistoryDBDAOsearchCHSMovementHistoryDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMovementHistoryDBDAOsearchCHSMovementHistoryDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2013.03.12 조경완 [CHM-201323142-01] Movement History를 근거로 Master Data 조회 가능하도록 수정
	  * </pre>
	  */
	public ChassisMovementHistoryDBDAOsearchCHSMovementHistoryDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("str_mvmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_mvmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.integration").append("\n"); 
		query.append("FileName : ChassisMovementHistoryDBDAOsearchCHSMovementHistoryDataRSQL").append("\n"); 
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
		query.append("SELECT AAA.*" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT ROWNUM AS NO" ).append("\n"); 
		query.append(",AA.*" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT B.MVMT_STS_CD" ).append("\n"); 
		query.append(", TO_CHAR(B.MVMT_DT,'YYYY-MM-DD HH24:MI') MVMT_DT" ).append("\n"); 
		query.append(", B.YD_CD" ).append("\n"); 
		query.append(", B.DEST_YD_CD" ).append("\n"); 
		query.append(", B.CNTR_NO" ).append("\n"); 
		query.append(", DECODE(I.CNTR_NO ,NULL,H.CHSS_USE_CO_NM,'SMLINE' ) CNTR_OWNR_CO_CD" ).append("\n"); 
		query.append(", B.DIFF_RMK" ).append("\n"); 
		query.append(", TO_CHAR(B.CRE_DT,'YYYY-MM-DD HH24:MI') CRE_DT" ).append("\n"); 
		query.append(", B.CRE_USR_ID" ).append("\n"); 
		query.append(", C.OFC_CD CRE_OFC_CD" ).append("\n"); 
		query.append(", C.USR_NM CRE_USR_NM" ).append("\n"); 
		query.append(", TO_CHAR(B.UPD_DT,'YYYY-MM-DD HH24:MI') UPD_DT" ).append("\n"); 
		query.append(", B.UPD_USR_ID" ).append("\n"); 
		query.append(", D.OFC_CD UPD_OFC_CD" ).append("\n"); 
		query.append(", D.USR_NM UPD_USR_NM" ).append("\n"); 
		query.append(", B.VNDR_SEQ" ).append("\n"); 
		query.append(", E.VNDR_ABBR_NM" ).append("\n"); 
		query.append(", B.MGST_NO MG_SET_NO" ).append("\n"); 
		query.append(", B.CNMV_YR" ).append("\n"); 
		query.append(", B.CNMV_ID_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("--CGM_EQUIPMENT A," ).append("\n"); 
		query.append("CGM_CHSS_MVMT_HIS B" ).append("\n"); 
		query.append(",COM_USER C" ).append("\n"); 
		query.append(",COM_USER D" ).append("\n"); 
		query.append(",MDM_VENDOR E" ).append("\n"); 
		query.append(",CGM_POOL_MVMT_HIS H" ).append("\n"); 
		query.append(",MST_CONTAINER I" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("B.CHSS_NO = @[eq_no]" ).append("\n"); 
		query.append("AND B.CNTR_NO = I.CNTR_NO(+)" ).append("\n"); 
		query.append("AND B.CRE_USR_ID = C.USR_ID(+)" ).append("\n"); 
		query.append("AND B.UPD_USR_ID = D.USR_ID(+)" ).append("\n"); 
		query.append("AND B.VNDR_SEQ   = E.VNDR_SEQ (+)" ).append("\n"); 
		query.append("AND  H.CHSS_NO (+)= B.CHSS_NO" ).append("\n"); 
		query.append("AND  H.YD_CD (+)= B.YD_CD" ).append("\n"); 
		query.append("AND  H.MVMT_DT       (+)= B.MVMT_DT" ).append("\n"); 
		query.append("#if ( ${str_mvmt_dt} != '' )" ).append("\n"); 
		query.append("AND B.MVMT_DT BETWEEN  TO_DATE(@[str_mvmt_dt],'YYYY-MM-DD')  AND  TO_DATE(@[end_mvmt_dt],'YYYY-MM-DD') +1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY B.MVMT_DT ,B.CNMV_YR,B.CNMV_ID_NO" ).append("\n"); 
		query.append(") AA" ).append("\n"); 
		query.append(") AAA" ).append("\n"); 
		query.append("#if ( ${str_mvmt_dt} == '' )" ).append("\n"); 
		query.append("WHERE AAA.NO < 301" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}