/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMovementHistoryDBDAOmodifyChsMoveByStatusDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2010.01.08 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI MIN HOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMovementHistoryDBDAOmodifyChsMoveByStatusDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 장비 Lost 관련 'Found' movement 를 입력한다.    
	  * </pre>
	  */
	public ChassisMovementHistoryDBDAOmodifyChsMoveByStatusDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_dt2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.integration").append("\n"); 
		query.append("FileName : ChassisMovementHistoryDBDAOmodifyChsMoveByStatusDataUSQL").append("\n"); 
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
		query.append("UPDATE CGM_CHSS_MVMT_HIS" ).append("\n"); 
		query.append("SET  MVMT_DT  = TO_DATE(@[mvmt_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",YD_CD    = @[yd_cd]" ).append("\n"); 
		query.append(",LOC_CD        = SUBSTR(@[yd_cd],1,5)" ).append("\n"); 
		query.append(",SCC_CD        = (SELECT SCC_CD FROM MDM_LOCATION AA WHERE LOC_CD = SUBSTR(@[yd_cd],1,5) )" ).append("\n"); 
		query.append(",LCC_CD        = (SELECT BB.LCC_CD FROM MDM_LOCATION AA, MDM_EQ_ORZ_CHT BB" ).append("\n"); 
		query.append("WHERE AA.LOC_CD = SUBSTR(@[yd_cd],1,5)" ).append("\n"); 
		query.append("AND AA.SCC_CD = BB.SCC_CD" ).append("\n"); 
		query.append("AND ROWNUM=1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",UPD_DT    = SYSDATE" ).append("\n"); 
		query.append("WHERE CHSS_NO = @[chss_no]" ).append("\n"); 
		query.append("AND MVMT_DT  = TO_DATE(@[mvmt_dt2],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 

	}
}