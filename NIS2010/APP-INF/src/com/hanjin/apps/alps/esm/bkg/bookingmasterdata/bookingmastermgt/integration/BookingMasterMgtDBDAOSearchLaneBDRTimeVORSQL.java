/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingMasterMgtDBDAOSearchLaneBDRTimeVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2009.11.06 이일민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ilmin Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOSearchLaneBDRTimeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BDR TIME 등록화면 Lane조회
	  * </pre>
	  */
	public BookingMasterMgtDBDAOSearchLaneBDRTimeVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cb_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cb_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cb_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOSearchLaneBDRTimeVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	POL_CD" ).append("\n"); 
		query.append(",	POD_CD" ).append("\n"); 
		query.append(",	POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append(",	SLAN_CD" ).append("\n"); 
		query.append(",	SLAN_TP_CD" ).append("\n"); 
		query.append(",	TRNK_BDR_FLG" ).append("\n"); 
		query.append(",	TO_CHAR(TRNK_ESTM_BDR_DT,'YYYY-MM-DD') TRNK_ESTM_BDR_DT" ).append("\n"); 
		query.append(",	TRNK_AUTO_BDR_FLG" ).append("\n"); 
		query.append(",	TO_CHAR(TRNK_AUTO_BDR_DT,'YYYY-MM-DD') TRNK_AUTO_BDR_DT" ).append("\n"); 
		query.append(",	TRNK_MNL_BDR_FLG" ).append("\n"); 
		query.append(",	TO_CHAR(TRNK_MNL_BDR_DT,'YYYY-MM-DD') TRNK_MNL_BDR_DT" ).append("\n"); 
		query.append(",	TRNK_BDR_CRE_USR_ID" ).append("\n"); 
		query.append(",	FDR_BDR_FLG" ).append("\n"); 
		query.append(",	TO_CHAR(FDR_ESTM_BDR_DT,'YYYY-MM-DD') FDR_ESTM_BDR_DT" ).append("\n"); 
		query.append(",	FDR_AUTO_BDR_FLG" ).append("\n"); 
		query.append(",	FDR_AUTO_BDR_DT" ).append("\n"); 
		query.append(",	FDR_MNL_BDR_FLG" ).append("\n"); 
		query.append(",	TO_CHAR(FDR_MNL_BDR_DT,'YYYY-MM-DD') FDR_MNL_BDR_DT" ).append("\n"); 
		query.append(",	FDR_BDR_CRE_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(FDR_BDR_UPD_DT,'YYYY-MM-DD') FDR_BDR_UPD_DT" ).append("\n"); 
		query.append(",	BDR_VSL_CHK_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	'' VVD" ).append("\n"); 
		query.append(",	'' OPT_SEL_BDR" ).append("\n"); 
		query.append(",	'' OPT_SEL_TIME" ).append("\n"); 
		query.append(",	'' CB_SLAN_CD" ).append("\n"); 
		query.append(",	'' CB_SKD_DIR_CD" ).append("\n"); 
		query.append(",	'' CB_POL_CD" ).append("\n"); 
		query.append("FROM BKG_VVD_BDR_LOG" ).append("\n"); 
		query.append("WHERE	1=1" ).append("\n"); 
		query.append("#if (${cb_slan_cd} != '')" ).append("\n"); 
		query.append("AND SLAN_CD = @[cb_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cb_skd_dir_cd} != '')" ).append("\n"); 
		query.append("AND	SKD_DIR_CD = @[cb_skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cb_pol_cd} != '')" ).append("\n"); 
		query.append("AND	POL_CD = @[cb_pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}