/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistBkgDocIssRdemRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.26
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.01.26 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchHistBkgDocIssRdemRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistBkgDocIssRdemRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistBkgDocIssRdemRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_rdem_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_rdem_cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("his_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistBkgDocIssRdemRSQL").append("\n"); 
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
		query.append("WITH OLD_RDEM AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT @[bkg_no] AS BKG_NO" ).append("\n"); 
		query.append(",@[his_seq] AS HIS_SEQ" ).append("\n"); 
		query.append(",@[evnt_ofc_cd] AS EVNT_OFC_CD" ).append("\n"); 
		query.append(",@[iss_rdem_knt] AS ISS_RDEM_KNT" ).append("\n"); 
		query.append(",@[evnt_usr_id] AS EVNT_USR_ID" ).append("\n"); 
		query.append(",@[evnt_dt] AS EVNT_DT" ).append("\n"); 
		query.append(",@[obl_rdem_cfm_flg] AS OBL_RDEM_CFM_FLG" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT HIS_CATE_NM" ).append("\n"); 
		query.append(",PRE_CTNT" ).append("\n"); 
		query.append(",CRNT_CTNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 'ISSUE/RLS CANCEL' HIS_CATE_NM" ).append("\n"); 
		query.append(",OLD_RDEM.ISS_RDEM_KNT || '/' || OLD_RDEM.EVNT_OFC_CD || '/' ||" ).append("\n"); 
		query.append("OLD_RDEM.EVNT_USR_ID || '/' || TO_CHAR(TO_DATE(OLD_RDEM.EVNT_DT, 'RRRR-MM-DD HH24:MI:SS'), 'YYYYMMDD') PRE_CTNT" ).append("\n"); 
		query.append(",NOW_RDEM.ISS_RDEM_KNT || '/' || NOW_RDEM.EVNT_OFC_CD || '/' ||" ).append("\n"); 
		query.append("NOW_RDEM.EVNT_USR_ID || '/' || TO_CHAR(NOW_RDEM.EVNT_DT, 'YYYYMMDD') CRNT_CTNT" ).append("\n"); 
		query.append("FROM BKG_DOC_ISS_RDEM NOW_RDEM" ).append("\n"); 
		query.append(",OLD_RDEM" ).append("\n"); 
		query.append("WHERE OLD_RDEM.BKG_NO      = NOW_RDEM.BKG_NO (+)" ).append("\n"); 
		query.append("AND OLD_RDEM.HIS_SEQ     = NOW_RDEM.HIS_SEQ (+)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE NVL(TRIM(PRE_CTNT), ' ') <> NVL(TRIM(CRNT_CTNT), ' ')" ).append("\n"); 

	}
}