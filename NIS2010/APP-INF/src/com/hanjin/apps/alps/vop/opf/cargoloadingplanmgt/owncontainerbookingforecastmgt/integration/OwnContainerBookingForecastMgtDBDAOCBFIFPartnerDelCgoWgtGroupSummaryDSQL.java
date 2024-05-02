/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOCBFIFPartnerDelCgoWgtGroupSummaryDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.24 
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

public class OwnContainerBookingForecastMgtDBDAOCBFIFPartnerDelCgoWgtGroupSummaryDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Partner CBF의 Weight Group Summary 삭제
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOCBFIFPartnerDelCgoWgtGroupSummaryDSQL(){
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
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOCBFIFPartnerDelCgoWgtGroupSummaryDSQL").append("\n"); 
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
		query.append("DELETE " ).append("\n"); 
		query.append("    FROM OPF_CGO_BKG_FCAST_WGT_GRP_SMRY A" ).append("\n"); 
		query.append("   WHERE A.VSL_CD           = @[vsl_cd]" ).append("\n"); 
		query.append("     AND A.SKD_VOY_NO       = @[skd_voy_no]" ).append("\n"); 
		query.append("     AND A.SKD_DIR_CD       = @[skd_dir_cd]" ).append("\n"); 
		query.append("     AND A.YD_CD||A.POL_CLPT_IND_SEQ  = @[yd_cd]" ).append("\n"); 
		query.append("     AND A.CRR_CD  IN ( SELECT DISTINCT CRR_CD" ).append("\n"); 
		query.append("                          FROM OPF_PRNR_EDI_CGO_BKG_FCAST" ).append("\n"); 
		query.append("                         WHERE VSL_CD           = A.VSL_CD  " ).append("\n"); 
		query.append("                           AND SKD_VOY_NO       = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND SKD_DIR_CD       = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND YD_CD            = A.YD_CD " ).append("\n"); 
		query.append("                           AND POL_CLPT_IND_SEQ = A.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                           AND UPLD_DT IS NULL )" ).append("\n"); 

	}
}