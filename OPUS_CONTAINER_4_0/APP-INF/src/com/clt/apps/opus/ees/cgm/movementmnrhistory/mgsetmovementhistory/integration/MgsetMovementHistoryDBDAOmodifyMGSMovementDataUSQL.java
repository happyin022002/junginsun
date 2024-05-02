/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MgsetMovementHistoryDBDAOmodifyMGSMovementDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MgsetMovementHistoryDBDAOmodifyMGSMovementDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public MgsetMovementHistoryDBDAOmodifyMGSMovementDataUSQL(){
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
		params.put("sys_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gate_io_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.integration ").append("\n"); 
		query.append("FileName : MgsetMovementHistoryDBDAOmodifyMGSMovementDataUSQL").append("\n"); 
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
		query.append("UPDATE CGM_MGST_MVMT_HIS" ).append("\n"); 
		query.append("    SET YD_CD         = @[yd_cd]," ).append("\n"); 
		query.append("        LOC_CD        = SUBSTR(@[yd_cd],1,5) ," ).append("\n"); 
		query.append("        SCC_CD        = (SELECT SCC_CD FROM MDM_LOCATION AA WHERE LOC_CD = SUBSTR(@[yd_cd],1,5) ) ," ).append("\n"); 
		query.append("        LCC_CD        = (SELECT BB.LCC_CD FROM MDM_LOCATION AA, MDM_EQ_ORZ_CHT BB" ).append("\n"); 
		query.append("                          WHERE AA.LOC_CD = SUBSTR(@[yd_cd],1,5)" ).append("\n"); 
		query.append("                            AND AA.SCC_CD = BB.SCC_CD " ).append("\n"); 
		query.append("                            AND ROWNUM=1" ).append("\n"); 
		query.append("                         ) ," ).append("\n"); 
		query.append("        DEST_YD_CD    = @[dest_yd_cd]," ).append("\n"); 
		query.append("        GATE_IO_CD    = @[gate_io_cd]," ).append("\n"); 
		query.append("        VNDR_SEQ      = @[vndr_abbr_nm]," ).append("\n"); 
		query.append("        MVMT_RSN_CD   = @[mvmt_rsn_cd]," ).append("\n"); 
		query.append("        CHSS_NO       = @[chss_no]," ).append("\n"); 
		query.append("        DIFF_RMK      = @[diff_rmk]," ).append("\n"); 
		query.append("        UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("        UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE MGST_NO = @[eq_no]  " ).append("\n"); 
		query.append(" AND MVMT_DT  = TO_DATE(@[mvmt_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(" AND SYS_SEQ  = @[sys_seq]" ).append("\n"); 

	}
}