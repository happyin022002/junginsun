/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOCBFIFSummaryPodUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.12 
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

public class OwnContainerBookingForecastMgtDBDAOCBFIFSummaryPodUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OwnContainerBookingForecastMgtDBDAOCBFIFSummaryPod
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOCBFIFSummaryPodUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_20ft_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blck_stwg_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_40ft_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_40ft_hc_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_45ft_hc_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOCBFIFSummaryPodUSQL").append("\n"); 
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
		query.append("UPDATE OPF_CGO_BKG_FCAST_SMRY" ).append("\n"); 
		query.append("SET    BKG_20FT_QTY = @[bkg_20ft_qty]" ).append("\n"); 
		query.append("       , BKG_40FT_QTY = @[bkg_40ft_qty]" ).append("\n"); 
		query.append("       , BKG_40FT_HC_QTY = @[bkg_40ft_hc_qty]" ).append("\n"); 
		query.append("       , BKG_45FT_HC_QTY = @[bkg_45ft_hc_qty]" ).append("\n"); 
		query.append("	   , UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("	   , UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHERE VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("   AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("   AND POL_CLPT_IND_SEQ = @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("   AND CRR_CD     = @[crr_cd]" ).append("\n"); 
		query.append("   AND POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("   AND BLCK_STWG_CD = @[blck_stwg_cd]" ).append("\n"); 

	}
}