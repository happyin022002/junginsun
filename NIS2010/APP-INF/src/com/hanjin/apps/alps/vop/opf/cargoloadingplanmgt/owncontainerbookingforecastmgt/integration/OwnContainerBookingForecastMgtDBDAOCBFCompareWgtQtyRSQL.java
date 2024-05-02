/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOCBFCompareWgtQtyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOCBFCompareWgtQtyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * weight group 의 수량과 main 화면의 수량 비교
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOCBFCompareWgtQtyRSQL(){
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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration ").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOCBFCompareWgtQtyRSQL").append("\n"); 
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
		query.append("WITH WGT_FLG AS (" ).append("\n"); 
		query.append(" SELECT COUNT(1) AS CNT " ).append("\n"); 
		query.append("   FROM OPF_CGO_BKG_FCAST_WGT_GRP_SMRY" ).append("\n"); 
		query.append("  WHERE VSL_CD     = substr(@[vvd],1,4)" ).append("\n"); 
		query.append("    AND SKD_VOY_NO = substr(@[vvd],5,4)   " ).append("\n"); 
		query.append("    AND SKD_DIR_CD = substr(@[vvd],9,1)" ).append("\n"); 
		query.append("    AND YD_CD||POL_CLPT_IND_SEQ   = @[yd_cd]" ).append("\n"); 
		query.append("    AND CRR_CD     = @[crr_cd]), " ).append("\n"); 
		query.append("CBF_QTY AS (" ).append("\n"); 
		query.append(" SELECT BLCK_STWG_CD,  SUM(BKG_20FT_QTY) AS BKG_20FT_QTY , " ).append("\n"); 
		query.append("                       SUM(BKG_40FT_QTY) AS BKG_40FT_QTY , " ).append("\n"); 
		query.append("                       SUM(BKG_40FT_HC_QTY) AS BKG_40FT_HC_QTY, " ).append("\n"); 
		query.append("                       SUM(BKG_45FT_HC_QTY) AS BKG_45FT_HC_QTY" ).append("\n"); 
		query.append("   FROM OPF_CGO_BKG_FCAST_SMRY" ).append("\n"); 
		query.append("  WHERE VSL_CD     = substr(@[vvd],1,4)" ).append("\n"); 
		query.append("    AND SKD_VOY_NO = substr(@[vvd],5,4)   " ).append("\n"); 
		query.append("    AND SKD_DIR_CD = substr(@[vvd],9,1)" ).append("\n"); 
		query.append("    AND YD_CD||POL_CLPT_IND_SEQ   = @[yd_cd]" ).append("\n"); 
		query.append("    AND CRR_CD     = @[crr_cd] " ).append("\n"); 
		query.append("  GROUP BY BLCK_STWG_CD ) ," ).append("\n"); 
		query.append("CBF_WGT AS (" ).append("\n"); 
		query.append(" SELECT BLCK_STWG_CD, SUM(DECODE(CNTR_SZ_CD,'2',CNTR_QTY)) AS BKG_20FT_QTY," ).append("\n"); 
		query.append("                      SUM(DECODE(CNTR_SZ_CD,'4',CNTR_QTY)) AS BKG_40FT_QTY," ).append("\n"); 
		query.append("                      SUM(DECODE(CNTR_SZ_CD,'5',CNTR_QTY)) AS BKG_40FT_HC_QTY," ).append("\n"); 
		query.append("                      SUM(DECODE(CNTR_SZ_CD,'6',CNTR_QTY)) AS BKG_45FT_HC_QTY" ).append("\n"); 
		query.append("   FROM OPF_CGO_BKG_FCAST_WGT_GRP_SMRY" ).append("\n"); 
		query.append("  WHERE VSL_CD     = substr(@[vvd],1,4)" ).append("\n"); 
		query.append("    AND SKD_VOY_NO = substr(@[vvd],5,4)   " ).append("\n"); 
		query.append("    AND SKD_DIR_CD = substr(@[vvd],9,1)" ).append("\n"); 
		query.append("    AND YD_CD||POL_CLPT_IND_SEQ   = @[yd_cd]" ).append("\n"); 
		query.append("    AND CRR_CD     = @[crr_cd]" ).append("\n"); 
		query.append("  GROUP BY BLCK_STWG_CD) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  SELECT A.BLCK_STWG_CD, DECODE(C.CNT,0,'Y',DECODE(NVL(A.BKG_20FT_QTY,0) - NVL(B.BKG_20FT_QTY,0),0,'Y','N')) AS FLG_20" ).append("\n"); 
		query.append("                       , DECODE(C.CNT,0,'Y',DECODE(NVL(A.BKG_40FT_QTY,0) - NVL(B.BKG_40FT_QTY,0),0,'Y','N')) AS FLG_40" ).append("\n"); 
		query.append("                       , DECODE(C.CNT,0,'Y',DECODE(NVL(A.BKG_40FT_HC_QTY,0) - NVL(B.BKG_40FT_HC_QTY,0),0,'Y','N')) AS FLG_40H" ).append("\n"); 
		query.append("                       , DECODE(C.CNT,0,'Y',DECODE(NVL(A.BKG_45FT_HC_QTY,0) - NVL(B.BKG_45FT_HC_QTY,0),0,'Y','N')) AS FLG_45" ).append("\n"); 
		query.append("   FROM CBF_QTY A, CBF_WGT B, WGT_FLG C" ).append("\n"); 
		query.append("  WHERE A.BLCK_STWG_CD = B.BLCK_STWG_CD(+)" ).append("\n"); 

	}
}