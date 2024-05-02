/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOCBFIFPartnerIfBkgDtCarrierCSQL.java
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

public class OwnContainerBookingForecastMgtDBDAOCBFIFPartnerIfBkgDtCarrierCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * partner edi 수신
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOCBFIFPartnerIfBkgDtCarrierCSQL(){
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
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOCBFIFPartnerIfBkgDtCarrierCSQL").append("\n"); 
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
		query.append("INSERT INTO OPF_CGO_BKG_FCAST_SMRY (" ).append("\n"); 
		query.append(" VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",YD_CD" ).append("\n"); 
		query.append(",POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append(",CRR_CD" ).append("\n"); 
		query.append(",POD_CD" ).append("\n"); 
		query.append(",BLCK_STWG_CD" ).append("\n"); 
		query.append(",CBF_IND_FLG" ).append("\n"); 
		query.append(",BKG_20FT_QTY" ).append("\n"); 
		query.append(",BKG_40FT_QTY" ).append("\n"); 
		query.append(",BKG_40FT_HC_QTY" ).append("\n"); 
		query.append(",BKG_45FT_HC_QTY" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[vsl_cd]," ).append("\n"); 
		query.append("       @[skd_voy_no]," ).append("\n"); 
		query.append("       @[skd_dir_cd],  " ).append("\n"); 
		query.append("       YD_CD, " ).append("\n"); 
		query.append("       POL_CLPT_IND_SEQ," ).append("\n"); 
		query.append("       X.CRR_CD,X.POD_CD, SUBSTR(X.POD_CD,3,3),'P'," ).append("\n"); 
		query.append("       SUM(DECODE(Y.CNTR_SZ_CD,'2',1,'3',1,NULL))," ).append("\n"); 
		query.append("       SUM(DECODE(Y.CNTR_SZ_CD,'4',1,NULL))," ).append("\n"); 
		query.append("       SUM(DECODE(Y.CNTR_SZ_CD,'5',1,DECODE(X.CNTR_TPSZ_CD,'R8',1,'R9',1,NULL)))," ).append("\n"); 
		query.append("       SUM(DECODE(X.CNTR_TPSZ_CD,'R8',NULL,'R9',NULL,DECODE(Y.CNTR_SZ_CD,'6',1,'7',1,'8',1,'9',1)))," ).append("\n"); 
		query.append("       @[cre_usr_id]," ).append("\n"); 
		query.append("       SYSDATE," ).append("\n"); 
		query.append("       @[upd_usr_id]," ).append("\n"); 
		query.append("       SYSDATE" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("    SELECT DISTINCT D.POD_CD, D.CNTR_NO, D.CNTR_TPSZ_CD, D.CRR_CD, D.YD_CD, D.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("      FROM (   SELECT DISTINCT  MAX(A.EDI_RCV_DT) AS EDI_RCV_DT ,   MAX(A.EDI_SND_ID) AS EDI_SND_ID " ).append("\n"); 
		query.append("                 FROM OPF_PRNR_EDI_CGO_BKG_FCAST A" ).append("\n"); 
		query.append("                WHERE A.VSL_CD           = @[vsl_cd]" ).append("\n"); 
		query.append("                  AND A.SKD_VOY_NO       = @[skd_voy_no]" ).append("\n"); 
		query.append("                  AND A.SKD_DIR_CD       = @[skd_dir_cd]" ).append("\n"); 
		query.append("                  AND A.YD_CD            = @[pol_cd]" ).append("\n"); 
		query.append("                  AND A.POL_CLPT_IND_SEQ = @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("                  AND A.UPLD_DT IS NULL" ).append("\n"); 
		query.append("                  AND A.CRR_CD <> 'SML'" ).append("\n"); 
		query.append("                  AND NOT EXISTS (     SELECT DISTINCT EDI_RCV_DT, EDI_SND_ID " ).append("\n"); 
		query.append("                                         FROM OPF_PRNR_EDI_CGO_BKG_FCAST" ).append("\n"); 
		query.append("                                        WHERE EDI_RCV_DT       = A.EDI_RCV_DT" ).append("\n"); 
		query.append("                                          AND EDI_SND_ID       = A.EDI_SND_ID" ).append("\n"); 
		query.append("                                          AND ( CRR_CD IS NULL OR POD_CD IS NULL OR CNTR_TPSZ_CD IS NULL ) )" ).append("\n"); 
		query.append("                 GROUP BY A.CRR_CD, A.YD_CD, A.POL_CLPT_IND_SEQ ) C, OPF_PRNR_EDI_CGO_BKG_FCAST D" ).append("\n"); 
		query.append("     WHERE C.EDI_RCV_DT = D.EDI_RCV_DT" ).append("\n"); 
		query.append("       AND C.EDI_SND_ID = D.EDI_SND_ID ) X, OPF_CNTR_TYPE_SIZE_V Y" ).append("\n"); 
		query.append("   WHERE X.CNTR_TPSZ_CD = Y.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("   GROUP BY X.CRR_CD, X.POD_CD, YD_CD, POL_CLPT_IND_SEQ,SUBSTR(X.POD_CD,3,3 )" ).append("\n"); 

	}
}