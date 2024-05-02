/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOCBFAllDataDSQL.java
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

public class OwnContainerBookingForecastMgtDBDAOCBFAllDataDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 vvd,yard의 cbf 정보 삭제
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOCBFAllDataDSQL(){
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
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOCBFAllDataDSQL").append("\n"); 
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
		query.append("#if (${del_tab} == '1') " ).append("\n"); 
		query.append("  DELETE OPF_CGO_BKG_FCAST_WGT_SMRY" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${del_tab} == '2') " ).append("\n"); 
		query.append("  DELETE OPF_CGO_BKG_FCAST_DG_DTL" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${del_tab} == '3') " ).append("\n"); 
		query.append("  DELETE OPF_CGO_BKG_FCAST_SPCL_SMRY" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${del_tab} == '4') " ).append("\n"); 
		query.append("  DELETE OPF_CGO_BKG_FCAST_SMRY" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${del_tab} == '5') " ).append("\n"); 
		query.append("  DELETE OPF_CGO_BKG_FCAST_WGT_GRP_SMRY" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append(" WHERE VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("   AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND YD_CD||POL_CLPT_IND_SEQ  = @[yd_cd]" ).append("\n"); 

	}
}