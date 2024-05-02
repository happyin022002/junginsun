/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetAttachDetachHistoryDBDAOmodifyMGSCurrentLocationDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.26
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.05.26 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetAttachDetachHistoryDBDAOmodifyMGSCurrentLocationDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetAttachDetachHistoryDBDAOmodifyMGSCurrentLocationDataUSQL
	  * </pre>
	  */
	public ChassisMgsetAttachDetachHistoryDBDAOmodifyMGSCurrentLocationDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetAttachDetachHistoryDBDAOmodifyMGSCurrentLocationDataUSQL").append("\n"); 
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
		query.append("UPDATE CGM_EQUIPMENT A" ).append("\n"); 
		query.append("SET (CRNT_LOC_CD, A.CRNT_YD_CD)=" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT SUBSTR(CURR_YD,1,5),CURR_YD FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("/*+ INDEX_DESC(A XPKCGM_EQ_ATCH_DTCH_HIS) */" ).append("\n"); 
		query.append("DECODE( DTCH_YD_CD, NULL, ATCH_YD_CD,DTCH_YD_CD ) CURR_YD" ).append("\n"); 
		query.append(",DECODE( DTCH_YD_CD, NULL, ATCH_DT,DTCH_DT ) CURR_DT" ).append("\n"); 
		query.append("FROM CGM_EQ_ATCH_DTCH_HIS A" ).append("\n"); 
		query.append("WHERE EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("AND ROWNUM=1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT /*+ INDEX_DESC(A XAK4CGM_EQ_STS_HIS) */" ).append("\n"); 
		query.append("STS_EVNT_YD_CD,STS_EVNT_DT  FROM CGM_EQ_STS_HIS A" ).append("\n"); 
		query.append("WHERE EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("ORDER BY  CURR_DT DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM=1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",UPD_DT = SYSDATE" ).append("\n"); 
		query.append(",UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("WHERE EQ_NO = @[eq_no]" ).append("\n"); 

	}
}