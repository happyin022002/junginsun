/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMovementHistoryDBDAOsearchCHSBareMvmtDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.09
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.11.09 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI MIN HOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMovementHistoryDBDAOsearchCHSBareMvmtDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ChassisMovementHistoryDBDAOsearchCHSBareMvmtDataRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.integration").append("\n"); 
		query.append("FileName : ChassisMovementHistoryDBDAOsearchCHSBareMvmtDataRSQL").append("\n"); 
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
		query.append("SELECT A.EQ_NO" ).append("\n"); 
		query.append(",A.CRNT_YD_CD" ).append("\n"); 
		query.append(",TO_CHAR(A.CHSS_MVMT_DT,'YYYY-MM-DD HH24:MI') CHSS_MVMT_DT" ).append("\n"); 
		query.append(", B.YD_CD" ).append("\n"); 
		query.append(", B.DEST_YD_CD" ).append("\n"); 
		query.append(", TO_CHAR(B.MVMT_DT,'YYYY-MM-DD HH24:MI') MVMT_DT_DAY" ).append("\n"); 
		query.append(", TO_CHAR(B.MVMT_DT,'HH24:MI') MVMT_DT_HD" ).append("\n"); 
		query.append(", B.MVMT_STS_CD" ).append("\n"); 
		query.append(", B.GATE_IO_CD" ).append("\n"); 
		query.append(", B.MVMT_CO_CD" ).append("\n"); 
		query.append(", B.VNDR_SEQ" ).append("\n"); 
		query.append(", C.VNDR_ABBR_NM" ).append("\n"); 
		query.append(", B.MVMT_RSN_CD" ).append("\n"); 
		query.append(", B.MGST_NO" ).append("\n"); 
		query.append(", B.DIFF_RMK" ).append("\n"); 
		query.append(", '' VERIFY" ).append("\n"); 
		query.append(", TO_CHAR(B.CRE_DT,'YYYY-MM-DD HH24:MI') CRE_DT" ).append("\n"); 
		query.append(", B.CRE_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(B.UPD_DT,'YYYY-MM-DD HH24:MI') UPD_DT" ).append("\n"); 
		query.append(", B.UPD_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(B.MVMT_DT ,'YYYY-MM-DD HH24:MI:SS')  MVMT_DT" ).append("\n"); 
		query.append(", B.SYS_SEQ" ).append("\n"); 
		query.append(", B.MNL_INP_FLG" ).append("\n"); 
		query.append(", D.CNTR_NO AT_CNTR_NO" ).append("\n"); 
		query.append(", E.CNTR_NO DT_CNTR_NO" ).append("\n"); 
		query.append(", CASE WHEN E.CNTR_NO  IS NOT NULL THEN" ).append("\n"); 
		query.append("E.CNTR_NO" ).append("\n"); 
		query.append("WHEN D.CNTR_NO  IS NOT NULL THEN" ).append("\n"); 
		query.append("D.CNTR_NO" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("'OK'" ).append("\n"); 
		query.append("END AS AT_DT_STATUS" ).append("\n"); 
		query.append("FROM CGM_EQUIPMENT A" ).append("\n"); 
		query.append(", CGM_CHSS_MVMT_HIS B" ).append("\n"); 
		query.append(", MDM_VENDOR C" ).append("\n"); 
		query.append(", CGM_EQ_ATCH_DTCH_HIS D" ).append("\n"); 
		query.append(", CGM_EQ_ATCH_DTCH_HIS E" ).append("\n"); 
		query.append("WHERE A.EQ_KND_CD= 'Z'" ).append("\n"); 
		query.append("AND A.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("AND A.EQ_NO = B.CHSS_NO" ).append("\n"); 
		query.append("AND B.VNDR_SEQ   = C.VNDR_SEQ (+)" ).append("\n"); 
		query.append("AND B.CHSS_NO =D.EQ_NO (+)" ).append("\n"); 
		query.append("AND B.MVMT_DT =D.ATCH_DT (+)" ).append("\n"); 
		query.append("AND D.ATCH_DTCH_SEQ(+)  = 1" ).append("\n"); 
		query.append("AND B.CHSS_NO =E.EQ_NO (+)" ).append("\n"); 
		query.append("AND B.MVMT_DT =E.DTCH_DT (+)" ).append("\n"); 
		query.append("AND E. ATCH_DTCH_SEQ(+)  = 1" ).append("\n"); 
		query.append("AND B.MVMT_DT BETWEEN  TO_DATE(@[str_mvmt_dt],'YYYY-MM-DD')  AND  TO_DATE(@[end_mvmt_dt],'YYYY-MM-DD') + 1" ).append("\n"); 

	}
}