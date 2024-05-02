/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingMasterMgtDBDAOSearchVvdBDRTimeVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.11
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.05.11 김기종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOSearchVvdBDRTimeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BDR TIME 등록화면 Vvd조회
	  * </pre>
	  */
	public BookingMasterMgtDBDAOSearchVvdBDRTimeVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOSearchVvdBDRTimeVORSQL").append("\n"); 
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
		query.append(",	CASE WHEN TRNK_BDR_FLG = 'Y' OR TRNK_AUTO_BDR_FLG = 'Y' OR TRNK_MNL_BDR_FLG = 'Y' THEN 'Y' ELSE 'N' END  TRNK_BDR_FLG" ).append("\n"); 
		query.append(",	TO_CHAR(TRNK_ESTM_BDR_DT,'YYYY-MM-DD') TRNK_ESTM_BDR_DT" ).append("\n"); 
		query.append(", 	DECODE(TRNK_AUTO_BDR_FLG,'Y','A',Decode(TRNK_MNL_BDR_FLG,'Y','M',' ')) TRNK_AUTO_BDR_FLG" ).append("\n"); 
		query.append(",	TO_CHAR(TRNK_AUTO_BDR_DT,'YYYY-MM-DD') TRNK_AUTO_BDR_DT" ).append("\n"); 
		query.append(",	TRNK_MNL_BDR_FLG" ).append("\n"); 
		query.append(",	TO_CHAR(TRNK_MNL_BDR_DT,'YYYY-MM-DD') TRNK_MNL_BDR_DT" ).append("\n"); 
		query.append(",	TRNK_BDR_CRE_USR_ID" ).append("\n"); 
		query.append(",	CASE WHEN FDR_BDR_FLG = 'Y' OR FDR_AUTO_BDR_FLG = 'Y' OR FDR_MNL_BDR_FLG = 'Y' THEN 'Y' ELSE 'N' END FDR_BDR_FLG" ).append("\n"); 
		query.append(",	TO_CHAR(FDR_ESTM_BDR_DT,'YYYY-MM-DD') FDR_ESTM_BDR_DT" ).append("\n"); 
		query.append(", 	DECODE(FDR_AUTO_BDR_FLG,'Y','A',Decode(FDR_MNL_BDR_FLG,'Y','M',' ')) FDR_AUTO_BDR_FLG" ).append("\n"); 
		query.append(",	TO_CHAR(FDR_AUTO_BDR_DT,'YYYY-MM-DD') FDR_AUTO_BDR_DT" ).append("\n"); 
		query.append(",	FDR_MNL_BDR_FLG" ).append("\n"); 
		query.append(",	TO_CHAR(FDR_MNL_BDR_DT,'YYYY-MM-DD') FDR_MNL_BDR_DT" ).append("\n"); 
		query.append(",	FDR_BDR_CRE_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(FDR_BDR_UPD_DT,'YYYY-MM-DD HH24:MI') FDR_BDR_UPD_DT" ).append("\n"); 
		query.append(",	BDR_VSL_CHK_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(UPD_DT,'YYYY-MM-DD HH24:MI') UPD_DT" ).append("\n"); 
		query.append(",	'' VVD" ).append("\n"); 
		query.append(",	'' OPT_SEL_BDR" ).append("\n"); 
		query.append(",	'' OPT_SEL_TIME" ).append("\n"); 
		query.append("FROM BKG_VVD_BDR_LOG" ).append("\n"); 
		query.append("WHERE	1=1" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("AND   VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND   SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND   SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("AND	POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("AND	POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}