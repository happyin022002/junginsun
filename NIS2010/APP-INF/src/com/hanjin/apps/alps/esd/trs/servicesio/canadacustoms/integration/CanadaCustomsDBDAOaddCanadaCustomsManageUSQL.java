/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CanadaCustomsDBDAOaddCanadaCustomsManageUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.canadacustoms.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CanadaCustomsDBDAOaddCanadaCustomsManageUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * update EDI_CND_CSTMS_IBD
	  * </pre>
	  */
	public CanadaCustomsDBDAOaddCanadaCustomsManageUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibd_ipi_locl_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnd_loc_gds_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibd_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibd_bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_dchg_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibd_cstms_clr_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibd_cstms_clr_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ibd_non_vsl_op_crr_ftr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibd_trsp_hub_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.canadacustoms.integration ").append("\n"); 
		query.append("FileName : CanadaCustomsDBDAOaddCanadaCustomsManageUSQL").append("\n"); 
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
		query.append("UPDATE EDI_CND_CSTMS_IBD SET" ).append("\n"); 
		query.append("BKG_NO                    		= @[bkg_no]" ).append("\n"); 
		query.append(", VSL_CD                    		= @[vsl_cd]" ).append("\n"); 
		query.append(", SKD_VOY_NO                	    = @[skd_voy_no]" ).append("\n"); 
		query.append(", SKD_DIR_CD                		= @[skd_dir_cd]" ).append("\n"); 
		query.append(", VSL_DCHG_PORT_CD          		= @[vsl_dchg_port_cd]" ).append("\n"); 
		query.append(", IBD_TRSP_HUB_CTY_CD       		= @[ibd_trsp_hub_cty_cd]" ).append("\n"); 
		query.append(", IBD_CSTMS_CLR_LOC_CD      		= @[ibd_cstms_clr_loc_cd]" ).append("\n"); 
		query.append(", IBD_BKG_STS_CD            		= @[ibd_bkg_sts_cd]" ).append("\n"); 
		query.append(", IBD_TP_CD                 	    = @[ibd_tp_cd]" ).append("\n"); 
		query.append(", IBD_NO                    		= @[ibd_no]" ).append("\n"); 
		query.append(", IBD_ISS_DT                		= TO_DATE(@[ibd_iss_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append(", IBD_CSTMS_CLR_IND_CD      		= @[ibd_cstms_clr_ind_cd]" ).append("\n"); 
		query.append(", IBD_IPI_LOCL_IND_CD       		= @[ibd_ipi_locl_ind_cd]" ).append("\n"); 
		query.append(", IBD_NON_VSL_OP_CRR_FTR_CD 		= @[ibd_non_vsl_op_crr_ftr_cd]" ).append("\n"); 
		query.append(", CND_LOC_GDS_CD            	    = @[cnd_loc_gds_cd]" ).append("\n"); 
		query.append(", EAI_EVNT_DT						= to_date(@[eai_evnt_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append("WHERE 	  BL_NO								= @[bl_no]" ).append("\n"); 
		query.append("AND 	NVL(EAI_EVNT_DT, to_date(20070505,'yyyymmddhh24miss'))  <= to_date(@[eai_evnt_dt],'yyyymmddhh24miss')" ).append("\n"); 

	}
}