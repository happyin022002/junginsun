/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOIFSummaryIfBkgDiffRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.14 
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

public class OwnContainerBookingForecastMgtDBDAOIFSummaryIfBkgDiffRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * korea cll과 booking interface시 서로 차이가 있는 cntr no list
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOIFSummaryIfBkgDiffRSQL(){
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
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOIFSummaryIfBkgDiffRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(NVL(LENGTH(WM_CONCAT(CNTR_NO)),0),0,'N','Y') AS CNTR_FLAG" ).append("\n"); 
		query.append(" FROM ( SELECT CNTR_NO " ).append("\n"); 
		query.append("    FROM ( ( SELECT DISTINCT CNTR_NO  " ).append("\n"); 
		query.append("            FROM BKG_CSTMS_TML_KR_CLL" ).append("\n"); 
		query.append("           WHERE VSL_CD            = @[vsl_cd]" ).append("\n"); 
		query.append("             AND SKD_VOY_NO        = @[skd_voy_no]" ).append("\n"); 
		query.append("             AND SKD_DIR_CD        = @[skd_dir_cd]" ).append("\n"); 
		query.append("             AND POL_CD||POL_YD_CD = SUBSTR(@[yd_cd],1,7)" ).append("\n"); 
		query.append("           MINUS" ).append("\n"); 
		query.append("           SELECT DISTINCT BCT.CNTR_NO" ).append("\n"); 
		query.append("             FROM BKG_VVD       VVD, " ).append("\n"); 
		query.append("                  BKG_BOOKING   BKG," ).append("\n"); 
		query.append("                  BKG_CONTAINER BCT" ).append("\n"); 
		query.append("            WHERE VVD.VSL_CD                          = @[vsl_cd]" ).append("\n"); 
		query.append("              AND VVD.SKD_VOY_NO                      = @[skd_voy_no]" ).append("\n"); 
		query.append("              AND VVD.SKD_DIR_CD                      = @[skd_dir_cd]" ).append("\n"); 
		query.append("              AND VVD.POL_YD_CD||VVD.POL_CLPT_IND_SEQ = @[yd_cd]    " ).append("\n"); 
		query.append("              AND VVD.BKG_NO                          = BKG.BKG_NO" ).append("\n"); 
		query.append("              AND BKG.BKG_STS_CD                      <> 'X'" ).append("\n"); 
		query.append("              AND BKG.BKG_NO                          = BCT.BKG_NO )" ).append("\n"); 
		query.append("          UNION " ).append("\n"); 
		query.append("         (  SELECT DISTINCT BCT.CNTR_NO" ).append("\n"); 
		query.append("              FROM BKG_VVD       VVD, " ).append("\n"); 
		query.append("                   BKG_BOOKING   BKG," ).append("\n"); 
		query.append("                   BKG_CONTAINER BCT" ).append("\n"); 
		query.append("             WHERE VVD.VSL_CD                          = @[vsl_cd]" ).append("\n"); 
		query.append("               AND VVD.SKD_VOY_NO                      = @[skd_voy_no]" ).append("\n"); 
		query.append("               AND VVD.SKD_DIR_CD                      = @[skd_dir_cd]" ).append("\n"); 
		query.append("               AND VVD.POL_YD_CD||VVD.POL_CLPT_IND_SEQ = @[yd_cd]       " ).append("\n"); 
		query.append("               AND VVD.BKG_NO                          = BKG.BKG_NO" ).append("\n"); 
		query.append("               AND BKG.BKG_STS_CD                      <> 'X'" ).append("\n"); 
		query.append("               AND BKG.BKG_NO                          = BCT.BKG_NO" ).append("\n"); 
		query.append("           MINUS" ).append("\n"); 
		query.append("           SELECT DISTINCT CNTR_NO  " ).append("\n"); 
		query.append("             FROM BKG_CSTMS_TML_KR_CLL" ).append("\n"); 
		query.append("            WHERE VSL_CD            = @[vsl_cd]" ).append("\n"); 
		query.append("              AND SKD_VOY_NO        = @[skd_voy_no]" ).append("\n"); 
		query.append("              AND SKD_DIR_CD        = @[skd_dir_cd]" ).append("\n"); 
		query.append("              AND POL_CD||POL_YD_CD = SUBSTR(@[yd_cd],1,7) ) )" ).append("\n"); 
		query.append("      WHERE ROWNUM = 1 )" ).append("\n"); 

	}
}