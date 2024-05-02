/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChassisMgsetAttachDetachHistoryDBDAOmodifyMGSDetachByMgstDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetAttachDetachHistoryDBDAOmodifyMGSDetachByMgstDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ChassisMgsetAttachDetachHistoryDBDAOmodifyMGSDetachByMgstDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mgst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetAttachDetachHistoryDBDAOmodifyMGSDetachByMgstDataUSQL").append("\n"); 
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
		query.append("-- Mgset_no 로 atch 상태인 Atdt History 를 Detach 시킴." ).append("\n"); 
		query.append("--   관련 Cntr_no 다음 Mvmt_dt와 Mgset_no 다음 Mvmt_dt 중 먼저 발생한 event date,yd 를 detach_dt,yd 로 사용" ).append("\n"); 
		query.append("--   해당 Cntr 와 detach 대상 Cntr 의 TPSZ 가 모두  D2 일때는 수행안함" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE /*+ bypass_ujvc */" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("    DTCH_YD_CD,DTCH_DT,EVNT_DT,EVNT_YD" ).append("\n"); 
		query.append("     FROM (" ).append("\n"); 
		query.append("         SELECT " ).append("\n"); 
		query.append("         DTCH_YD_CD," ).append("\n"); 
		query.append("         DTCH_DT," ).append("\n"); 
		query.append("         CASE WHEN CNTR_EVNT_DT < MGST_EVNT_DT THEN CNTR_EVNT_DT " ).append("\n"); 
		query.append("              WHEN CNTR_EVNT_DT > MGST_EVNT_DT THEN MGST_EVNT_DT " ).append("\n"); 
		query.append("         END EVNT_DT," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("         CASE WHEN CNTR_EVNT_DT < MGST_EVNT_DT THEN CNTR_EVNT_YD " ).append("\n"); 
		query.append("              WHEN CNTR_EVNT_DT > MGST_EVNT_DT THEN MGST_EVNT_YD " ).append("\n"); 
		query.append("         END EVNT_YD" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("            A.EQ_NO," ).append("\n"); 
		query.append("            A.ATCH_DT," ).append("\n"); 
		query.append("            A.CNTR_NO," ).append("\n"); 
		query.append("            B.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("            A.DTCH_YD_CD," ).append("\n"); 
		query.append("            A.DTCH_DT," ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            NVL( (  SELECT /*+ INDEX(M XAK2CTM_MOVEMENT) */ CNMV_EVNT_DT " ).append("\n"); 
		query.append("                    FROM CTM_MOVEMENT  M" ).append("\n"); 
		query.append("                    WHERE M.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("                    AND M.CNMV_EVNT_DT > A.ATCH_DT " ).append("\n"); 
		query.append("                    AND ROWNUM=1 ) , to_date('88881231','YYYYMMDD') )  CNTR_EVNT_DT," ).append("\n"); 
		query.append("            (SELECT /*+ INDEX(M XAK2CTM_MOVEMENT) */  ORG_YD_CD " ).append("\n"); 
		query.append("             FROM CTM_MOVEMENT  M" ).append("\n"); 
		query.append("             WHERE M.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("             AND M.CNMV_EVNT_DT > A.ATCH_DT  " ).append("\n"); 
		query.append("             AND ROWNUM=1 ) CNTR_EVNT_YD," ).append("\n"); 
		query.append("            NVL( (   SELECT /*+ INDEX(M XAK17CTM_MOVEMENT) */  CNMV_EVNT_DT " ).append("\n"); 
		query.append("                    FROM CTM_MOVEMENT  M" ).append("\n"); 
		query.append("                    WHERE M.MGST_NO = A.EQ_NO" ).append("\n"); 
		query.append("                    AND M.CNMV_EVNT_DT > A.ATCH_DT  " ).append("\n"); 
		query.append("                    AND ROWNUM=1 ) , to_date('88881231','YYYYMMDD') ) MGST_EVNT_DT," ).append("\n"); 
		query.append("            (SELECT /*+ INDEX(M XAK17CTM_MOVEMENT) */  ORG_YD_CD " ).append("\n"); 
		query.append("             FROM CTM_MOVEMENT  M" ).append("\n"); 
		query.append("             WHERE M.MGST_NO = A.EQ_NO" ).append("\n"); 
		query.append("             AND M.CNMV_EVNT_DT > A.ATCH_DT  " ).append("\n"); 
		query.append("             AND ROWNUM=1 ) MGST_EVNT_YD" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("             FROM CGM_EQ_ATCH_DTCH_HIS A , MST_CONTAINER B" ).append("\n"); 
		query.append("            WHERE EQ_NO = @[mgst_no]" ).append("\n"); 
		query.append("            AND DTCH_DT = to_date('88881231','YYYYMMDD')" ).append("\n"); 
		query.append("            AND A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("WHERE EVNT_DT IS NOT NULL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("set DTCH_YD_CD = EVNT_YD" ).append("\n"); 
		query.append("   ,DTCH_DT =   EVNT_DT" ).append("\n"); 

	}
}