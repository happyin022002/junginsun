/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PerformanceReportDBDAODocQueueBkgHistList3VOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAODocQueueBkgHistList3VOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * update
	  * </pre>
	  */
	public PerformanceReportDBDAODocQueueBkgHistList3VOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sr_mtch_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAODocQueueBkgHistList3VOUSQL").append("\n"); 
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
		query.append("UPDATE BKG_SR_CRNT_RQST SET " ).append("\n"); 
		query.append("	SR_WRK_STS_CD	=	@[sr_mtch_sts_cd] " ).append("\n"); 
		query.append(",	SR_WRK_STS_DT	=	GLOBALDATE_PKG.TIME_LOCAL_FNC('MYPKG')" ).append("\n"); 
		query.append(",   SR_WRK_STS_USR_ID = @[usr_id]" ).append("\n"); 
		query.append(",	FNT_OFC_TRNS_DT   = GLOBALDATE_PKG.TIME_LOCAL_FNC('MYPKG')" ).append("\n"); 
		query.append(",   FNT_OFC_SNDR_ID   = @[usr_id]" ).append("\n"); 
		query.append(",   FNT_OFC_CD        = @[ofc_cd]" ).append("\n"); 
		query.append(",   DPCS_OFC_CD       = 'PKGSA'" ).append("\n"); 
		query.append(",   SR_CRNT_STS_CD    = 'ST'" ).append("\n"); 
		query.append(",   SR_CRNT_INFO_CD   = 'N'" ).append("\n"); 
		query.append(",   UPD_DT           = SYSDATE" ).append("\n"); 
		query.append(",   UPD_USR_ID       = @[usr_id]" ).append("\n"); 
		query.append("WHERE	SR_KND_CD = @[sr_knd_cd]" ).append("\n"); 
		query.append("AND	SR_NO = @[sr_no]" ).append("\n"); 
		query.append("AND	BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}