/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOCBFIFPartnerCgoGrsWgtCSQL.java
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

public class OwnContainerBookingForecastMgtDBDAOCBFIFPartnerCgoGrsWgtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PARTNER EDI 의 WGT
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOCBFIFPartnerCgoGrsWgtCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOCBFIFPartnerCgoGrsWgtCSQL").append("\n"); 
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
		query.append("INSERT INTO OPF_CGO_BKG_FCAST_WGT_SMRY ( " ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("YD_CD," ).append("\n"); 
		query.append("POL_CLPT_IND_SEQ," ).append("\n"); 
		query.append("CRR_CD," ).append("\n"); 
		query.append("CGO_GRS_WGT," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT )" ).append("\n"); 
		query.append(" SELECT X.VSL_CD, X.SKD_VOY_NO, X.SKD_DIR_CD,  X.YD_CD, X.POL_CLPT_IND_SEQ, X.CRR_CD, SUM(X.TTL_WGT), @[cre_usr_id],SYSDATE,@[upd_usr_id],SYSDATE" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("    SELECT DISTINCT VSL_CD, SKD_VOY_NO, SKD_DIR_CD,  YD_CD,POL_CLPT_IND_SEQ, CRR_CD , CNTR_NO, TTL_WGT " ).append("\n"); 
		query.append("      FROM (   SELECT DISTINCT  MAX(A.EDI_RCV_DT) AS EDI_RCV_DT ,   MAX(A.EDI_SND_ID) AS EDI_SND_ID " ).append("\n"); 
		query.append("                 FROM OPF_PRNR_EDI_CGO_BKG_FCAST A" ).append("\n"); 
		query.append("                WHERE A.VSL_CD           =  @[vsl_cd]" ).append("\n"); 
		query.append("                  AND A.SKD_VOY_NO       =  @[skd_voy_no]" ).append("\n"); 
		query.append("                  AND A.SKD_DIR_CD       =  @[skd_dir_cd]" ).append("\n"); 
		query.append("                  AND A.YD_CD            =  @[pol_cd]" ).append("\n"); 
		query.append("                  AND A.POL_CLPT_IND_SEQ =  @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("                  AND A.UPLD_DT IS NULL" ).append("\n"); 
		query.append("                  AND A.CRR_CD <> 'SML'" ).append("\n"); 
		query.append("                  AND NOT EXISTS (     SELECT DISTINCT EDI_RCV_DT, EDI_SND_ID " ).append("\n"); 
		query.append("                                         FROM OPF_PRNR_EDI_CGO_BKG_FCAST" ).append("\n"); 
		query.append("                                        WHERE EDI_RCV_DT       = A.EDI_RCV_DT" ).append("\n"); 
		query.append("                                          AND EDI_SND_ID       = A.EDI_SND_ID" ).append("\n"); 
		query.append("                                          AND ( CRR_CD IS NULL OR POD_CD IS NULL OR CNTR_TPSZ_CD IS NULL ) )" ).append("\n"); 
		query.append("                 GROUP BY A.CRR_CD, A.YD_CD, A.POL_CLPT_IND_SEQ ) C, OPF_PRNR_EDI_CGO_BKG_FCAST D" ).append("\n"); 
		query.append("     WHERE C.EDI_RCV_DT = D.EDI_RCV_DT" ).append("\n"); 
		query.append("       AND C.EDI_SND_ID = D.EDI_SND_ID ) X" ).append("\n"); 
		query.append("GROUP BY X.VSL_CD, X.SKD_VOY_NO, X.SKD_DIR_CD,  X.YD_CD, X.POL_CLPT_IND_SEQ, X.CRR_CD" ).append("\n"); 

	}
}