/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMovementHistoryDBDAOmodifyCgmChssMvmtHisDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.03.12 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMovementHistoryDBDAOmodifyCgmChssMvmtHisDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * *Chassis movement 를 UPDATE 수행
	  *  CGM CHASSIS MOVEMENT 엔티티
	  * </pre>
	  */
	public ChassisMovementHistoryDBDAOmodifyCgmChssMvmtHisDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dest_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_abbr_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.integration").append("\n"); 
		query.append("FileName : ChassisMovementHistoryDBDAOmodifyCgmChssMvmtHisDataUSQL").append("\n"); 
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
		query.append("SET YD_CD         = @[org_yd_cd]," ).append("\n"); 
		query.append("LOC_CD        = SUBSTR(@[org_yd_cd],1,5) ," ).append("\n"); 
		query.append("SCC_CD        = (SELECT SCC_CD FROM MDM_LOCATION AA WHERE LOC_CD = SUBSTR(@[org_yd_cd],1,5) ) ," ).append("\n"); 
		query.append("LCC_CD        = (SELECT BB.LCC_CD FROM MDM_LOCATION AA, MDM_EQ_ORZ_CHT BB" ).append("\n"); 
		query.append("WHERE AA.LOC_CD = SUBSTR(@[org_yd_cd],1,5)" ).append("\n"); 
		query.append("AND AA.SCC_CD = BB.SCC_CD" ).append("\n"); 
		query.append("AND ROWNUM=1" ).append("\n"); 
		query.append(") ," ).append("\n"); 
		query.append("DEST_YD_CD    = @[dest_yd_cd]," ).append("\n"); 
		query.append("GATE_IO_CD    = (SELECT IO_BND_CD FROM MDM_MVMT_STS WHERE MVMT_STS_CD = @[mvmt_sts_cd]  AND ROWNUM =1 ) ," ).append("\n"); 
		query.append("VNDR_SEQ      = @[vndr_abbr_nm]," ).append("\n"); 
		query.append("MGST_NO       = @[mgst_no]," ).append("\n"); 
		query.append("DIFF_RMK      = @[diff_rmk]," ).append("\n"); 
		query.append("BKG_NO        = @[bkg_no]," ).append("\n"); 
		query.append("UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT = SYSDATE ," ).append("\n"); 
		query.append("MVMT_STS_CD = @[mvmt_sts_cd]" ).append("\n"); 
		query.append("WHERE CHSS_NO = @[chss_no]" ).append("\n"); 
		query.append("AND MVMT_DT  = TO_DATE(@[mvmt_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 

	}
}