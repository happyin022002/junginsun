/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchBkgBlMkDescHisForVarRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.31
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2014.03.31 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMIN CHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchBkgBlMkDescHisForVarRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchBkgBlMkDescHisForVarRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchBkgBlMkDescHisForVarRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_cluz_dp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchBkgBlMkDescHisForVarRSQL").append("\n"); 
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
		query.append("WITH OLD AS" ).append("\n"); 
		query.append("(SELECT @[bkg_no] BKG_NO" ).append("\n"); 
		query.append(", @[auto_cluz_dp_cd] AUTO_CLUZ_DP_CD" ).append("\n"); 
		query.append(", @[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append(", @[upd_dt] UPD_DT" ).append("\n"); 
		query.append("FROM DUAL)" ).append("\n"); 
		query.append("SELECT HIS_CATE_NM" ).append("\n"); 
		query.append("     , PRE_CTNT||'/'||OLD_UPD_DT||'/'|| OLD_UPD_USR_ID PRE_CTNT" ).append("\n"); 
		query.append("     , CRNT_CTNT||'/'||NOW_UPD_DT||'/'|| NOW_UPD_USR_ID CRNT_CTNT" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("		SELECT 'Auto Clause Display' HIS_CATE_NM" ).append("\n"); 
		query.append("        	, OLD.AUTO_CLUZ_DP_CD PRE_CTNT" ).append("\n"); 
		query.append("	        , NOW.AUTO_CLUZ_DP_CD CRNT_CTNT" ).append("\n"); 
		query.append("            , TO_CHAR(NOW.UPD_DT,'YYYY-MM-DD HH24:MI:SS') NOW_UPD_DT" ).append("\n"); 
		query.append("            , NOW.UPD_USR_ID NOW_UPD_USR_ID" ).append("\n"); 
		query.append("            , DECODE(OLD.AUTO_CLUZ_DP_CD,null,null,OLD.UPD_DT) OLD_UPD_DT" ).append("\n"); 
		query.append("            , DECODE(OLD.AUTO_CLUZ_DP_CD,null,null,OLD.UPD_USR_ID) OLD_UPD_USR_ID" ).append("\n"); 
		query.append("          FROM OLD " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("             , BKG_BL_MK_DESC_HIS NOW " ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("	       AND NOW.CORR_NO     (+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("             , BKG_BL_MK_DESC NOW " ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    )    " ).append("\n"); 
		query.append(" WHERE NVL(TRIM(PRE_CTNT), ' ') <> NVL(TRIM(CRNT_CTNT), ' ')" ).append("\n"); 

	}
}