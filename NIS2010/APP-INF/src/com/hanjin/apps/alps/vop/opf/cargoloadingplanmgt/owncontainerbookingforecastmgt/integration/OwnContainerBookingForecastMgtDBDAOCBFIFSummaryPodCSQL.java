/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOCBFIFSummaryPodCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.03 
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

public class OwnContainerBookingForecastMgtDBDAOCBFIFSummaryPodCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OwnContainerBookingForecastMgtDBDAOCBFIFSummaryPod
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOCBFIFSummaryPodCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cbf_ind_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_20ft_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_40ft_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOCBFIFSummaryPodCSQL").append("\n"); 
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
		query.append("                                    , SKD_VOY_NO" ).append("\n"); 
		query.append("                                    , SKD_DIR_CD" ).append("\n"); 
		query.append("                                    , YD_CD" ).append("\n"); 
		query.append("                                    , POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                    , CRR_CD" ).append("\n"); 
		query.append("                                    , POD_CD" ).append("\n"); 
		query.append("                                    , BLCK_STWG_CD" ).append("\n"); 
		query.append("									, CBF_IND_FLG" ).append("\n"); 
		query.append("                                    , BKG_20FT_QTY" ).append("\n"); 
		query.append("                                    , BKG_40FT_QTY" ).append("\n"); 
		query.append("                                    , BKG_40FT_HC_QTY" ).append("\n"); 
		query.append("                                    , BKG_45FT_HC_QTY" ).append("\n"); 
		query.append("                                    , CRE_USR_ID" ).append("\n"); 
		query.append("                                    , CRE_DT" ).append("\n"); 
		query.append("                                    , UPD_USR_ID" ).append("\n"); 
		query.append("                                    , UPD_DT" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("VALUES(@[vsl_cd]" ).append("\n"); 
		query.append("        , @[skd_voy_no]" ).append("\n"); 
		query.append("        , @[skd_dir_cd]" ).append("\n"); 
		query.append("        , @[yd_cd]" ).append("\n"); 
		query.append("        , @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("        , @[crr_cd]" ).append("\n"); 
		query.append("         ,DECODE(@[blck_stwg_cd],'SH1','CNSHA','SH2','CNSHA','PU1' ,'KRPUS'," ).append("\n"); 
		query.append("             NVL((SELECT LOC_CD" ).append("\n"); 
		query.append("                    FROM MDM_LOCATION WHERE LOC_CD = @[pod_cd] ) ,  " ).append("\n"); 
		query.append("                 (  SELECT ISO_PORT_CD  FROM STO_CD_PORT" ).append("\n"); 
		query.append("                    WHERE PORT_CD = @[pod_cd]" ).append("\n"); 
		query.append("				 )   ))" ).append("\n"); 
		query.append("        , @[blck_stwg_cd]" ).append("\n"); 
		query.append("		, @[cbf_ind_flg]" ).append("\n"); 
		query.append("        , @[bkg_20ft_qty]" ).append("\n"); 
		query.append("        , @[bkg_40ft_qty]" ).append("\n"); 
		query.append("        , @[bkg_40ft_hc_qty]" ).append("\n"); 
		query.append("        , @[bkg_45ft_hc_qty]" ).append("\n"); 
		query.append("        , @[cre_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        , @[upd_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}