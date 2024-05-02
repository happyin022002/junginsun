/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOsearchMGSAtdtHistoryDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.26
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.04.26 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOsearchMGSAtdtHistoryDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20091120 2006 At/Dt 추가
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOsearchMGSAtdtHistoryDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOsearchMGSAtdtHistoryDataRSQL").append("\n"); 
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
		query.append("DECODE(A.EQ_TPSZ_CD, 'CLG', B.CNTR_NO, 'UMG', B.CHSS_NO) CNTR_CHSS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--,DECODE (B.ATCH_DT, TO_DATE('88881231','YYYYMMDD'), '', TO_CHAR(B.ATCH_DT,'YYYY-MM-DD HH24:MI:SS')) AS ATCH_DT" ).append("\n"); 
		query.append(",DECODE (B.ATCH_DT,null,'', TO_DATE('88881231','YYYYMMDD'), '', TO_CHAR(B.ATCH_DT,'YYYYMMDD')) AS ATCH_DT_DAY" ).append("\n"); 
		query.append(",DECODE (B.ATCH_DT,null,'', TO_DATE('88881231','YYYYMMDD'), '', TO_CHAR(B.ATCH_DT,'HH24MI')) AS ATCH_DT_HD" ).append("\n"); 
		query.append(",B.ATCH_YD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--,DECODE (B.DTCH_DT, TO_DATE('88881231','YYYYMMDD'), '', TO_CHAR(B.DTCH_DT,'YYYY-MM-DD HH24:MI:SS')) AS DTCH_DT" ).append("\n"); 
		query.append(",DECODE (B.DTCH_DT,null,'', TO_DATE('88881231','YYYYMMDD'), '', TO_CHAR(B.DTCH_DT,'YYYYMMDD')) AS DTCH_DT_DAY" ).append("\n"); 
		query.append(",DECODE (B.DTCH_DT,null,'', TO_DATE('88881231','YYYYMMDD'), '', TO_CHAR(B.DTCH_DT,'HH24MI')) AS DTCH_DT_HD" ).append("\n"); 
		query.append(",B.DTCH_YD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM CGM_EQUIPMENT A, CGM_EQ_ATCH_DTCH_HIS B" ).append("\n"); 
		query.append("WHERE A.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("AND A.EQ_KND_CD ='G'" ).append("\n"); 
		query.append("AND A.EQ_NO = B.EQ_NO" ).append("\n"); 
		query.append("ORDER BY B.ATCH_DT" ).append("\n"); 

	}
}