/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOAddVskCustEdiLogToKlnetCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.12.30 서창열
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO CHANG YUL
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOAddVskCustEdiLogToKlnetCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddVskCustEdiLogToKlnet
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOAddVskCustEdiLogToKlnetCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_pos",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("header_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOAddVskCustEdiLogToKlnetCSQL").append("\n"); 
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
		query.append("INSERT INTO VSK_CUST_EDI_LOG" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("ROUT_RCV_DT	, CUST_TRD_PRNR_ID	, ROUT_SEQ          , VSKD_EDI_SND_ID   ," ).append("\n"); 
		query.append("N1ST_VSL_CD , N1ST_SKD_VOY_NO   , N1ST_SKD_DIR_CD   ," ).append("\n"); 
		query.append("CRE_USR_ID  , CRE_DT            , UPD_USR_ID, UPD_DT," ).append("\n"); 
		query.append("DIFF_RMK" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT	TO_CHAR(SYSDATE, 'YYYYMMDD')	AS ROUT_RCV_DT" ).append("\n"); 
		query.append(",@[port_pos]					AS CUST_TRD_PRNR_ID" ).append("\n"); 
		query.append(",(	SELECT	NVL(MAX(ROUT_SEQ), 0) + 1" ).append("\n"); 
		query.append("FROM	VSK_CUST_EDI_LOG" ).append("\n"); 
		query.append("WHERE	ROUT_RCV_DT	= TO_CHAR(SYSDATE, 'YYYYMMDD')" ).append("\n"); 
		query.append("AND		VSKD_EDI_SND_ID = @[header_seq]" ).append("\n"); 
		query.append(")						AS ROUT_SEQ" ).append("\n"); 
		query.append(",@[header_seq]" ).append("\n"); 
		query.append(",@[vsl_cd]" ).append("\n"); 
		query.append(",@[skd_voy_no]" ).append("\n"); 
		query.append(",@[skd_dir_cd]" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[diff_rmk]" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}