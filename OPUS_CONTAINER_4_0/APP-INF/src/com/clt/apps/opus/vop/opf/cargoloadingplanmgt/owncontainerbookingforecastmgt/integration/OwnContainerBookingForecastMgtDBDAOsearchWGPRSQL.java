/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOsearchWGPRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.10
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2010.04.10 김현욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Hyun Uk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOsearchWGPRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchWGP
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOsearchWGPRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_grs_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOsearchWGPRSQL").append("\n"); 
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
		query.append("SELECT W.WGT_GRP_CD_DESC" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD          V," ).append("\n"); 
		query.append("OPF_CGO_BKG_FCAST_WGT_GRP W" ).append("\n"); 
		query.append("WHERE V.VSL_CD                = @[vsl_cd]" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO            = @[skd_voy_no]" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD            = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND V.YD_CD||V.CLPT_IND_SEQ = @[yd_cd]" ).append("\n"); 
		query.append("AND V.SLAN_CD               = W.SLAN_CD" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD            = W.SKD_DIR_CD" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD           = W.POL_CD" ).append("\n"); 
		query.append("AND W.CNTR_SZ_CD            = DECODE(SUBSTR(@[cntr_tpsz_cd],2,1),'2','2','4')" ).append("\n"); 
		query.append("AND W.FULL_MTY_CD           = 'F'" ).append("\n"); 
		query.append("AND W.FM_LMT_WGT <= (TO_NUMBER(@[cntr_grs_wgt])/TO_NUMBER(@[cntr_qty])/1000)" ).append("\n"); 
		query.append("AND NVL(W.TO_LMT_WGT,999999.999) > (TO_NUMBER(@[cntr_grs_wgt])/TO_NUMBER(@[cntr_qty])/1000)" ).append("\n"); 

	}
}