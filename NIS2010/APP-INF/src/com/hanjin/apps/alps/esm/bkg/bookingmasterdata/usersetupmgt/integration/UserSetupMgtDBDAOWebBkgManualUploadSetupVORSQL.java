/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UserSetupMgtDBDAOWebBkgManualUploadSetupVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.05
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserSetupMgtDBDAOWebBkgManualUploadSetupVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WebBkgManualUploadSetupVO
	  * </pre>
	  */
	public UserSetupMgtDBDAOWebBkgManualUploadSetupVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
		query.append("FileName : UserSetupMgtDBDAOWebBkgManualUploadSetupVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("BKG_OFC_CD" ).append("\n"); 
		query.append(", BLCK_SEQ" ).append("\n"); 
		query.append(", VSL_SLAN_CD" ).append("\n"); 
		query.append(", VSL_CD" ).append("\n"); 
		query.append(", SKD_VOY_NO" ).append("\n"); 
		query.append(", VSL_CD||SKD_VOY_NO||DIR_CD AS VVD" ).append("\n"); 
		query.append(", CUST_CNT_CD||LPAD(CUST_SEQ,6,'0') AS CUST_CNT_CD" ).append("\n"); 
		query.append(", DIR_CD" ).append("\n"); 
		query.append(", CUST_SEQ" ).append("\n"); 
		query.append(", POL_CNT_CD" ).append("\n"); 
		query.append(", POL_CD" ).append("\n"); 
		query.append(", POD_CNT_CD" ).append("\n"); 
		query.append(", POD_CD" ).append("\n"); 
		query.append(", DELT_FLG" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(CRE_DT,'YYYY/MM/DD HH24:MI:SS') AS CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(CRE_DT,'YYYY/MM/DD HH24:MI:SS') AS UPD_DT" ).append("\n"); 
		query.append(", XTER_RMK" ).append("\n"); 
		query.append(", LODG_DIR_CD" ).append("\n"); 
		query.append("FROM BKG_SYS_UPLD_BLCK_STUP " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if(${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND BKG_OFC_CD LIKE '%'||@[bkg_ofc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY BKG_OFC_CD, BLCK_SEQ" ).append("\n"); 

	}
}