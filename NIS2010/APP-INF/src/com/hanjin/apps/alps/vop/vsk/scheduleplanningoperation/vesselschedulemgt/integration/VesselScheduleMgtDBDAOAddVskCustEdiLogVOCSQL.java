/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOAddVskCustEdiLogVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.04
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2010.10.04 유혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Hyuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOAddVskCustEdiLogVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSK_CUST_EDI_LOG 정보를 등록합니다.
	  * -------------------------------------------
	  * CHM-201006129-01 SKD 생성시 EDI 전송후 전송내역을 VSK_CUST_EDI_LOG 테이블에 저장
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOAddVskCustEdiLogVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vskd_edi_snd_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_trd_prnr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOAddVskCustEdiLogVOCSQL").append("\n"); 
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
		query.append("INSERT INTO VSK_CUST_EDI_LOG(" ).append("\n"); 
		query.append("    ROUT_RCV_DT" ).append("\n"); 
		query.append("    , ROUT_SEQ" ).append("\n"); 
		query.append("    , VSKD_EDI_SND_ID" ).append("\n"); 
		query.append("    , CUST_TRD_PRNR_ID" ).append("\n"); 
		query.append("    , N1ST_VSL_CD" ).append("\n"); 
		query.append("    , N1ST_SKD_VOY_NO" ).append("\n"); 
		query.append("    , N1ST_SKD_DIR_CD" ).append("\n"); 
		query.append("    , DIFF_RMK" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT)" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    TO_CHAR(SYSDATE, 'YYYYMMDD')	AS ROUT_RCV_DT" ).append("\n"); 
		query.append("	,(	SELECT NVL(MAX(ROUT_SEQ), 0) + 1" ).append("\n"); 
		query.append("		FROM   VSK_CUST_EDI_LOG" ).append("\n"); 
		query.append("		WHERE  ROUT_RCV_DT	= TO_CHAR(SYSDATE, 'YYYYMMDD')" ).append("\n"); 
		query.append("		AND    VSKD_EDI_SND_ID = @[vskd_edi_snd_id]) AS ROUT_SEQ" ).append("\n"); 
		query.append("    ,@[vskd_edi_snd_id]" ).append("\n"); 
		query.append("    ,@[cust_trd_prnr_id]" ).append("\n"); 
		query.append("    ,@[n1st_vsl_cd]" ).append("\n"); 
		query.append("    ,@[n1st_skd_voy_no]" ).append("\n"); 
		query.append("    ,@[n1st_skd_dir_cd]" ).append("\n"); 
		query.append("    ,@[diff_rmk]" ).append("\n"); 
		query.append("    ,@[cre_usr_id]" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append("    ,@[upd_usr_id]" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}