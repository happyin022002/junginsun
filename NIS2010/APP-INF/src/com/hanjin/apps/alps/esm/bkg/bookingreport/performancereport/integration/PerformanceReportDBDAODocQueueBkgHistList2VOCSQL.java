/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportDBDAODocQueueBkgHistList2VOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.07.02 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kang dong yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAODocQueueBkgHistList2VOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * create
	  * </pre>
	  */
	public PerformanceReportDBDAODocQueueBkgHistList2VOCSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_amd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_amd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_amd_rsn_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sr_amd_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("INSERT INTO BKG_SR_AMD_RSN (" ).append("\n"); 
		query.append("SR_KND_CD" ).append("\n"); 
		query.append(",	SR_NO" ).append("\n"); 
		query.append(",	BKG_NO" ).append("\n"); 
		query.append(",	SR_AMD_TP_CD" ).append("\n"); 
		query.append(",	SR_AMD_SEQ" ).append("\n"); 
		query.append(",	SR_AMD_RSN_TP_CD" ).append("\n"); 
		query.append(",	SR_AMD_RSN_CD" ).append("\n"); 
		query.append(",	SR_AMD_RSN_SEQ" ).append("\n"); 
		query.append(",	USR_GRP_CD" ).append("\n"); 
		query.append(",	AMD_RESPB_USR_ID" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[sr_knd_cd]" ).append("\n"); 
		query.append(",	@[sr_no]" ).append("\n"); 
		query.append(",	@[bkg_no]" ).append("\n"); 
		query.append(",	@[sr_amd_tp_cd]" ).append("\n"); 
		query.append(",	@[sr_amd_seq]" ).append("\n"); 
		query.append(",	@[sr_amd_rsn_tp_cd]" ).append("\n"); 
		query.append(",	@[sr_amd_rsn_cd]" ).append("\n"); 
		query.append(",	(SELECT NVL(MAX(SR_AMD_RSN_SEQ), 0)+1 AS" ).append("\n"); 
		query.append("FROM BKG_SR_AMD_RSN" ).append("\n"); 
		query.append("WHERE SR_KND_CD = @[sr_knd_cd]" ).append("\n"); 
		query.append("AND SR_NO = @[sr_no]" ).append("\n"); 
		query.append("AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND SR_AMD_TP_CD = @[sr_amd_tp_cd]" ).append("\n"); 
		query.append("AND SR_AMD_SEQ = @[sr_amd_seq]" ).append("\n"); 
		query.append("AND SR_AMD_RSN_TP_CD = @[sr_amd_rsn_tp_cd]" ).append("\n"); 
		query.append("AND SR_AMD_RSN_CD = @[sr_amd_rsn_cd])" ).append("\n"); 
		query.append(",	@[usr_grp_cd]" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAODocQueueBkgHistList2VOCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}