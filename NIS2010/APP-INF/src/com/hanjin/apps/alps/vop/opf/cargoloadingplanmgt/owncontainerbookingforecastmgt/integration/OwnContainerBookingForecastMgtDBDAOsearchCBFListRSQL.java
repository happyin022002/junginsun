/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOsearchCBFListRSQL.java
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

public class OwnContainerBookingForecastMgtDBDAOsearchCBFListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCBFList 조회
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOsearchCBFListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOsearchCBFListRSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append("     , A.CNTR_NO     " ).append("\n"); 
		query.append("     , A.POD_CD" ).append("\n"); 
		query.append("     , SUBSTR(A.POD_YD_CD,6,2) POD_YD_CD     " ).append("\n"); 
		query.append("     , A.MLB_CD     " ).append("\n"); 
		query.append("     , A.CRR_CD" ).append("\n"); 
		query.append("     , A.CNTR_TPSZ_CD     " ).append("\n"); 
		query.append("     , A.CNTR_WGT_GRP_CD     " ).append("\n"); 
		query.append("     , A.FULL_MTY_CD     " ).append("\n"); 
		query.append("     , A.DCGO_FLG" ).append("\n"); 
		query.append("     , A.RC_FLG" ).append("\n"); 
		query.append("     , A.AWK_CGO_FLG" ).append("\n"); 
		query.append("     , A.BB_CGO_FLG" ).append("\n"); 
		query.append("     , A.CGO_GRS_WGT" ).append("\n"); 
		query.append("     , A.CBF_DP_CD" ).append("\n"); 
		query.append("     , A.STWG_CD" ).append("\n"); 
		query.append("     , A.CNTR_GRS_WGT" ).append("\n"); 
		query.append("     , A.BKG_STS_CD   " ).append("\n"); 
		query.append("     , B.UPD_USR_ID     " ).append("\n"); 
		query.append("     , TO_CHAR(B.UPD_DT,'YYYY-MM-DD HH24:MI') UPD_DT" ).append("\n"); 
		query.append("     , A.VSL_CD" ).append("\n"); 
		query.append("     , A.SKD_VOY_NO" ).append("\n"); 
		query.append("     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("     , A.BKG_SHPR_OWNR_FLG" ).append("\n"); 
		query.append("     , A.YD_CD" ).append("\n"); 
		query.append("     , A.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("     , A.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("     , A.CBF_SMRY_SEQ" ).append("\n"); 
		query.append("     , A.SPCL_CGO_SEQ" ).append("\n"); 
		query.append("     , A.FWRD_OVR_DIM_LEN" ).append("\n"); 
		query.append("     , A.BKWD_OVR_DIM_LEN" ).append("\n"); 
		query.append("     , A.HGT_OVR_DIM_LEN" ).append("\n"); 
		query.append("     , B.CBF_IND_FLG" ).append("\n"); 
		query.append("     , B.CBF_BKG_STS_CD" ).append("\n"); 
		query.append("     , B.ACT_CNTR_FLG AS AC_CNTR_FLG" ).append("\n"); 
		query.append("     , 'R' RD_ST     " ).append("\n"); 
		query.append("  FROM OPF_CGO_BKG_FCAST_CNTR A" ).append("\n"); 
		query.append("     , OPF_CGO_BKG_FCAST      B" ).append("\n"); 
		query.append(" WHERE A.VSL_CD                    = @[vsl_cd]" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO                = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD                = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND A.BKG_SHPR_OWNR_FLG         = 'Y'" ).append("\n"); 
		query.append("   AND A.CRR_CD                    = 'SML'" ).append("\n"); 
		query.append("   AND A.YD_CD||A.POL_CLPT_IND_SEQ = @[yd_cd]" ).append("\n"); 
		query.append("   AND B.VSL_CD                    = A.VSL_CD                                                    " ).append("\n"); 
		query.append("   AND B.SKD_VOY_NO                = A.SKD_VOY_NO                                                    " ).append("\n"); 
		query.append("   AND B.SKD_DIR_CD                = A.SKD_DIR_CD                                                    " ).append("\n"); 
		query.append("   AND B.BKG_SHPR_OWNR_FLG         = A.BKG_SHPR_OWNR_FLG" ).append("\n"); 
		query.append("   AND B.CRR_CD                    = A.CRR_CD" ).append("\n"); 
		query.append("   AND B.YD_CD                     = A.YD_CD" ).append("\n"); 
		query.append("   AND B.POL_CLPT_IND_SEQ          = A.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("   AND A.CBF_DP_CD                 = 'V'" ).append("\n"); 
		query.append(" ORDER BY " ).append("\n"); 
		query.append("       A.POD_CD" ).append("\n"); 
		query.append("     , A.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("     , A.MLB_CD" ).append("\n"); 
		query.append("     , A.BKG_NO" ).append("\n"); 
		query.append("     , A.CNTR_NO" ).append("\n"); 
		query.append("     , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , A.CNTR_WGT_GRP_CD" ).append("\n"); 
		query.append("     , A.FULL_MTY_CD" ).append("\n"); 
		query.append("     , DECODE(A.DCGO_FLG,'Y','1',A.RC_FLG,'Y','2',A.AWK_CGO_FLG,'Y','3',A.BB_CGO_FLG,'Y','4')" ).append("\n"); 

	}
}