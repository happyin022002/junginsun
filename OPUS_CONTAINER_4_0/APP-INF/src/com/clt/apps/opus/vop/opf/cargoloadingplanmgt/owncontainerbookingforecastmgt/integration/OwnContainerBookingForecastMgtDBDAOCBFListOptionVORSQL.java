/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOCBFListOptionVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOCBFListOptionVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCBFList 조회
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOCBFListOptionVORSQL(){
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
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOCBFListOptionVORSQL").append("\n"); 
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
		query.append("     (A.POD_CD||A.POD_CLPT_IND_SEQ) AS POD_CD" ).append("\n"); 
		query.append(",    A.MLB_CD" ).append("\n"); 
		query.append(",    A.CRR_CD" ).append("\n"); 
		query.append(",    A.PRNR_CNTR_REF_NO" ).append("\n"); 
		query.append(",    A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",    DECODE(A.CNTR_WGT_GRP_CD,'X','Extra Heavy','H','Heavy','M','Medium','L','Light','E','Ultra Light',A.CNTR_WGT_GRP_CD) CNTR_WGT_GRP_CD" ).append("\n"); 
		query.append(",    A.FULL_MTY_CD" ).append("\n"); 
		query.append(",    A.CNTR_QTY" ).append("\n"); 
		query.append(",    A.CNTR_GRS_WGT" ).append("\n"); 
		query.append(",    B.UPD_USR_ID" ).append("\n"); 
		query.append(",    TO_CHAR(NVL(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',B.UPD_DT,'GMT'), B.UPD_DT), 'YYYY-MM-DD HH24:MI') UPD_DT" ).append("\n"); 
		query.append(",    A.VSL_CD" ).append("\n"); 
		query.append(",    A.SKD_VOY_NO" ).append("\n"); 
		query.append(",    A.SKD_DIR_CD" ).append("\n"); 
		query.append(",    A.YD_CD" ).append("\n"); 
		query.append(",    A.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append(",    A.BKG_SHPR_OWNR_FLG" ).append("\n"); 
		query.append(",    A.CBF_SMRY_SEQ" ).append("\n"); 
		query.append(", 	 'V' CBF_DP_CD" ).append("\n"); 
		query.append("FROM   OPF_CGO_BKG_FCAST_CNTR A, OPF_CGO_BKG_FCAST B" ).append("\n"); 
		query.append("WHERE  A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND    A.YD_CD||A.POL_CLPT_IND_SEQ = @[yd_cd]" ).append("\n"); 
		query.append("AND    A.CRR_CD = @[crr_cd]" ).append("\n"); 
		query.append("AND    A.BKG_SHPR_OWNR_FLG = 'N'" ).append("\n"); 
		query.append("AND    A.CRR_CD <> COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()" ).append("\n"); 
		query.append("AND    B.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("AND    B.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    B.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    B.YD_CD = A.YD_CD" ).append("\n"); 
		query.append("AND    B.POL_CLPT_IND_SEQ = A.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND    B.BKG_SHPR_OWNR_FLG = A.BKG_SHPR_OWNR_FLG" ).append("\n"); 
		query.append("AND    B.CRR_CD = A.CRR_CD" ).append("\n"); 
		query.append("AND    A.CBF_DP_CD = 'V'" ).append("\n"); 
		query.append("ORDER BY A.POD_CD, A.POD_CLPT_IND_SEQ, A.MLB_CD,A.PRNR_CNTR_REF_NO,A.CNTR_TPSZ_CD" ).append("\n"); 

	}
}