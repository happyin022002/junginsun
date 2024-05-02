/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfDcubeDgDSQL.java
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

public class OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfDcubeDgDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfDcubeDg
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfDcubeDgDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfDcubeDgDSQL").append("\n"); 
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
		query.append("DELETE OPF_CGO_BKG_FCAST_SPCL_SMRY" ).append("\n"); 
		query.append("WHERE (VSL_CD" ).append("\n"); 
		query.append("        , SKD_VOY_NO" ).append("\n"); 
		query.append("        , SKD_DIR_CD" ).append("\n"); 
		query.append("        , YD_CD" ).append("\n"); 
		query.append("        , POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("        , CRR_CD" ).append("\n"); 
		query.append("        , POD_CD" ).append("\n"); 
		query.append("        , BLCK_STWG_CD" ).append("\n"); 
		query.append("        , DCGO_FLG" ).append("\n"); 
		query.append("        ) IN (SELECT  @[vsl_cd]" ).append("\n"); 
		query.append("                        , @[skd_voy_no]" ).append("\n"); 
		query.append("                        , @[skd_dir_cd]" ).append("\n"); 
		query.append("                        , @[pol_cd]--SUBSTR([yd_cd],0,7)" ).append("\n"); 
		query.append("                        , @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("                        , CRR_CD" ).append("\n"); 
		query.append("                        , POD_CD" ).append("\n"); 
		query.append("                        , SUBSTR(POD_CD,3,4) AS BLCK_STWG_CD" ).append("\n"); 
		query.append("                        , 'Y'" ).append("\n"); 
		query.append("                FROM    (SELECT  B.CRR_CD" ).append("\n"); 
		query.append("                                , A.POL_CD" ).append("\n"); 
		query.append("                                , A.POD_CD" ).append("\n"); 
		query.append("                                , B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                , B.IMDG_UN_NO" ).append("\n"); 
		query.append("                                , B.IMDG_CLSS_CD" ).append("\n"); 
		query.append("                                , MRN_POLUT_FLG " ).append("\n"); 
		query.append("                                , COUNT(1) AS CNTR_QTY" ).append("\n"); 
		query.append("                                , ( SELECT NVL(MAX(CBF_SPCL_SMRY_SEQ),0)+1" ).append("\n"); 
		query.append("                                    FROM OPF_CGO_BKG_FCAST_SPCL_SMRY" ).append("\n"); 
		query.append("                                    WHERE VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("                                    AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                                    AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                                    AND YD_CD = A.POL_CD" ).append("\n"); 
		query.append("                                    AND POL_CLPT_IND_SEQ = @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("                                    ) AS CBF_SPCL_SMRY_SEQ" ).append("\n"); 
		query.append("                        FROM SCG_PRNR_APRO_RQST A" ).append("\n"); 
		query.append("                            , SCG_PRNR_APRO_RQST_CGO B" ).append("\n"); 
		query.append("                        WHERE A.VSL_CD=@[vsl_cd]" ).append("\n"); 
		query.append("                          AND A.SKD_VOY_NO=@[skd_voy_no]" ).append("\n"); 
		query.append("                          AND A.SKD_DIR_CD=@[skd_dir_cd]" ).append("\n"); 
		query.append("                          AND A.CRR_CD = B.CRR_CD" ).append("\n"); 
		query.append("                          AND A.BKG_REF_NO = B.BKG_REF_NO" ).append("\n"); 
		query.append("                          AND A.CRR_CD <> 'SML'" ).append("\n"); 
		query.append("                          AND A.DG_FLG ='Y'" ).append("\n"); 
		query.append("                          AND A.POL_CD =SUBSTR(@[yd_cd],0,5)" ).append("\n"); 
		query.append("                          GROUP BY B.CRR_CD, A.POL_CD, A.POD_CD, B.CNTR_TPSZ_CD, B.IMDG_UN_NO, B.IMDG_CLSS_CD, MRN_POLUT_FLG" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("				)" ).append("\n"); 

	}
}