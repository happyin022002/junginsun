/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOCBFIFSummaryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOCBFIFSummaryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OwnContainerBookingForecastMgtDBDAOCBFIFSummary
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOCBFIFSummaryCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOCBFIFSummaryCSQL").append("\n"); 
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
		query.append("INSERT INTO OPF_CGO_BKG_FCAST_SMRY	(VSL_CD" ).append("\n"); 
		query.append("					, SKD_VOY_NO" ).append("\n"); 
		query.append("					, SKD_DIR_CD" ).append("\n"); 
		query.append("					, YD_CD" ).append("\n"); 
		query.append("					, POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("					, CRR_CD" ).append("\n"); 
		query.append("					, POD_CD" ).append("\n"); 
		query.append("					, BLCK_STWG_CD" ).append("\n"); 
		query.append("					, CBF_IND_FLG" ).append("\n"); 
		query.append("					, CRE_USR_ID" ).append("\n"); 
		query.append("					, CRE_DT" ).append("\n"); 
		query.append("					, UPD_USR_ID" ).append("\n"); 
		query.append("					, UPD_DT" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("SELECT VSL_CD" ).append("\n"); 
		query.append("	, SKD_VOY_NO" ).append("\n"); 
		query.append("	, SKD_DIR_CD" ).append("\n"); 
		query.append("	, YD_CD" ).append("\n"); 
		query.append("	, POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("	, @[crr_cd]" ).append("\n"); 
		query.append("	, POD_CD" ).append("\n"); 
		query.append("	, BLCK_STWG_CD" ).append("\n"); 
		query.append("	, CBF_IND_FLG" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, SYSDATE" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, SYSDATE" ).append("\n"); 
		query.append("FROM OPF_CGO_BKG_FCAST_SMRY" ).append("\n"); 
		query.append(" WHERE VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("   AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND YD_CD = @[pol_cd]" ).append("\n"); 
		query.append("   AND POL_CLPT_IND_SEQ = @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("   AND CRR_CD     = 'SML'" ).append("\n"); 
		query.append("   --AND CRR_CD     = [crr_cd]" ).append("\n"); 
		query.append("   --AND POD_CD = [pod_cd]" ).append("\n"); 
		query.append("   --AND BLCK_STWG_CD = [blck_stwg_cd]" ).append("\n"); 

	}
}