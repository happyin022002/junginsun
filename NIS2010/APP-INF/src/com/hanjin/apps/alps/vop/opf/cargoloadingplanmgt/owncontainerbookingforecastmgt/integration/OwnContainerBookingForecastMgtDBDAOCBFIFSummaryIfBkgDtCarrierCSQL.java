/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtCarrierCSQL.java
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

public class OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtCarrierCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtCarrier
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtCarrierCSQL(){
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
		params.put("pol_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtCarrierCSQL").append("\n"); 
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
		query.append("SELECT  @[vsl_cd]" ).append("\n"); 
		query.append("        , @[skd_voy_no]" ).append("\n"); 
		query.append("        , @[skd_dir_cd]" ).append("\n"); 
		query.append("        , @[pol_cd]" ).append("\n"); 
		query.append("        , @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("        , 'SML'" ).append("\n"); 
		query.append("        , POD_CD" ).append("\n"); 
		query.append("        , SUBSTR(MLB,3,5)" ).append("\n"); 
		query.append("        , @[cbf_ind_flg]," ).append("\n"); 
		query.append("         SUM(DECODE(Y.CNTR_SZ_CD,'2',FULL_QTY,'3',FULL_QTY)) +  SUM(DECODE(Y.CNTR_SZ_CD,'2',MTY_QTY,'3',MTY_QTY))," ).append("\n"); 
		query.append("         SUM(DECODE(Y.CNTR_SZ_CD,'4',FULL_QTY)) + SUM(DECODE(Y.CNTR_SZ_CD,'4',MTY_QTY))," ).append("\n"); 
		query.append("         SUM(DECODE(Y.CNTR_TPSZ_CD,'R8',FULL_QTY,'R9',FULL_QTY,DECODE(Y.CNTR_SZ_CD,'5',FULL_QTY))) +  SUM(DECODE(Y.CNTR_TPSZ_CD,'R8',MTY_QTY,'R9',MTY_QTY, DECODE(Y.CNTR_SZ_CD,'5',MTY_QTY)))," ).append("\n"); 
		query.append("         SUM(DECODE(Y.CNTR_TPSZ_CD,'R8',0,'R9',0, DECODE(Y.CNTR_SZ_CD,'6',FULL_QTY,'7',FULL_QTY,'8',FULL_QTY,'9',FULL_QTY,'W',FULL_QTY,'X',FULL_QTY)))+" ).append("\n"); 
		query.append("         SUM(DECODE(Y.CNTR_TPSZ_CD,'R8',0,'R9',0, DECODE(Y.CNTR_SZ_CD,'6',MTY_QTY,'7',MTY_QTY,'8',MTY_QTY,'9',MTY_QTY,'W',MTY_QTY,'X',MTY_QTY)))" ).append("\n"); 
		query.append("        , @[cre_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        , @[upd_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE        " ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("   WITH EQ_CNTR AS" ).append("\n"); 
		query.append("   (  SELECT BKG.BKG_NO ,  " ).append("\n"); 
		query.append("             DECODE(BKG.RD_CGO_FLG,'Y',DECODE(SUBSTR(QTY.CNTR_TPSZ_CD,1,1),'R',SUBSTR(QTY.EQ_SUBST_CNTR_TPSZ_CD,1,1)||SUBSTR(QTY.CNTR_TPSZ_CD,2,1),QTY.CNTR_TPSZ_CD),QTY.CNTR_TPSZ_CD) CNTR_TPSZ_CD , QTY.OP_CNTR_QTY QTY , --QTY.OP_CNTR_QTY - NVL(QTY.EQ_SUBST_CGO_QTY,0) QTY , " ).append("\n"); 
		query.append("             OPF_BLCK_STWG_CD(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD, VVD.POL_YD_CD, VVD.POL_CLPT_IND_SEQ, BKG.BKG_NO) AS MLB , VVD.POD_CD" ).append("\n"); 
		query.append("        FROM BKG_VVD       VVD, " ).append("\n"); 
		query.append("             BKG_BOOKING   BKG," ).append("\n"); 
		query.append("             BKG_QUANTITY  QTY" ).append("\n"); 
		query.append("       WHERE VVD.VSL_CD                          = @[vsl_cd]        " ).append("\n"); 
		query.append("         AND VVD.SKD_VOY_NO                      = @[skd_voy_no]    " ).append("\n"); 
		query.append("         AND VVD.SKD_DIR_CD                      = @[skd_dir_cd]    " ).append("\n"); 
		query.append("         AND VVD.POL_YD_CD||VVD.POL_CLPT_IND_SEQ = @[yd_cd]          " ).append("\n"); 
		query.append("         AND VVD.BKG_NO                          = BKG.BKG_NO" ).append("\n"); 
		query.append("        #if(${bkg_sts_cd} != 'All')" ).append("\n"); 
		query.append("         AND BKG.BKG_STS_CD = @[bkg_sts_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("         AND BKG.BKG_STS_CD  <> 'X'" ).append("\n"); 
		query.append("         AND BKG.BKG_NO        = QTY.BKG_NO  " ).append("\n"); 
		query.append("         AND BKG.BKG_CGO_TP_CD ='F'  -- FULL " ).append("\n"); 
		query.append("         AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%' " ).append("\n"); 
		query.append("         ) " ).append("\n"); 
		query.append("    SELECT X.POD_CD, X.MLB, X.CNTR_TPSZ_CD, SUM(X.QTY) FULL_QTY, 0 MTY_QTY" ).append("\n"); 
		query.append("      FROM  EQ_CNTR  X" ).append("\n"); 
		query.append("     GROUP BY X.POD_CD,  X.MLB, X.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("  UNION ALL " ).append("\n"); 
		query.append("  SELECT X.POD_CD, X.MLB, X.CNTR_TPSZ_CD, 0 FULL_QTY, ALL_QTY - NVL(BN_QTY,0) MTY_QTY" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("          SELECT VVD.POD_CD, QTY.CNTR_TPSZ_CD , SUM(OP_CNTR_QTY) ALL_QTY ," ).append("\n"); 
		query.append("                 OPF_BLCK_STWG_CD(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD, VVD.POL_YD_CD, VVD.POL_CLPT_IND_SEQ, BKG.BKG_NO) AS MLB " ).append("\n"); 
		query.append("            FROM BKG_VVD       VVD, " ).append("\n"); 
		query.append("                 BKG_BOOKING   BKG," ).append("\n"); 
		query.append("                 BKG_QUANTITY  QTY," ).append("\n"); 
		query.append("                 MDM_CNTR_SZ   MCZ" ).append("\n"); 
		query.append("           WHERE VVD.VSL_CD                          = @[vsl_cd]  --HNCH0112W KRPUSHN1" ).append("\n"); 
		query.append("             AND VVD.SKD_VOY_NO                      = @[skd_voy_no]" ).append("\n"); 
		query.append("             AND VVD.SKD_DIR_CD                      = @[skd_dir_cd]" ).append("\n"); 
		query.append("             AND VVD.POL_YD_CD||VVD.POL_CLPT_IND_SEQ = @[yd_cd] " ).append("\n"); 
		query.append("             AND VVD.BKG_NO                          = BKG.BKG_NO" ).append("\n"); 
		query.append("         	#if(${bkg_sts_cd} != 'All')" ).append("\n"); 
		query.append("          	AND BKG.BKG_STS_CD = @[bkg_sts_cd]" ).append("\n"); 
		query.append("         	#end" ).append("\n"); 
		query.append("             AND BKG.BKG_STS_CD                      <> 'X'" ).append("\n"); 
		query.append("             AND BKG.BKG_NO                          = QTY.BKG_NO  " ).append("\n"); 
		query.append("             AND BKG.BKG_CGO_TP_CD                   <> 'F'" ).append("\n"); 
		query.append("             AND QTY.CNTR_TPSZ_CD                    NOT LIKE 'Q%'" ).append("\n"); 
		query.append("             AND SUBSTR(QTY.CNTR_TPSZ_CD,2,1)        = MCZ.CNTR_SZ_CD" ).append("\n"); 
		query.append("         GROUP BY VVD.POD_CD, QTY.CNTR_TPSZ_CD,   " ).append("\n"); 
		query.append("                   OPF_BLCK_STWG_CD(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD, VVD.POL_YD_CD, VVD.POL_CLPT_IND_SEQ, BKG.BKG_NO)) X , (" ).append("\n"); 
		query.append("                    SELECT OPF_BLCK_STWG_CD(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD, VVD.POL_YD_CD, VVD.POL_CLPT_IND_SEQ, BKG.BKG_NO) AS MLB, " ).append("\n"); 
		query.append("                           BC.CNTR_TPSZ_CD, COUNT(1) BN_QTY" ).append("\n"); 
		query.append("                      FROM BKG_VVD       VVD, " ).append("\n"); 
		query.append("               BKG_BOOKING   BKG," ).append("\n"); 
		query.append("               BKG_CONTAINER BC      " ).append("\n"); 
		query.append("        WHERE VVD.VSL_CD                          = @[vsl_cd]" ).append("\n"); 
		query.append("          AND VVD.SKD_VOY_NO                      = @[skd_voy_no]" ).append("\n"); 
		query.append("          AND VVD.SKD_DIR_CD                      = @[skd_dir_cd]" ).append("\n"); 
		query.append("          AND VVD.POL_YD_CD||VVD.POL_CLPT_IND_SEQ = @[yd_cd] " ).append("\n"); 
		query.append("          AND VVD.BKG_NO                          = BKG.BKG_NO" ).append("\n"); 
		query.append("         #if(${bkg_sts_cd} != 'All')" ).append("\n"); 
		query.append("          AND BKG.BKG_STS_CD = @[bkg_sts_cd]" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("          AND BKG.BKG_STS_CD  <> 'X'" ).append("\n"); 
		query.append("          AND BKG.BKG_CGO_TP_CD <> 'F'" ).append("\n"); 
		query.append("          AND BKG.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("          AND NVL(BC.MCNTR_BDL_NO,0) <> 0" ).append("\n"); 
		query.append("          AND BC.BDL_BTM_FLG ='N'" ).append("\n"); 
		query.append("        GROUP BY BC.CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("                 OPF_BLCK_STWG_CD(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD, VVD.POL_YD_CD, VVD.POL_CLPT_IND_SEQ, BKG.BKG_NO)" ).append("\n"); 
		query.append("                    ) Y" ).append("\n"); 
		query.append("    WHERE X.MLB = Y.MLB(+)" ).append("\n"); 
		query.append("    AND X.CNTR_TPSZ_CD = Y.CNTR_TPSZ_CD (+)    " ).append("\n"); 
		query.append("        ) X, MDM_CNTR_TP_SZ  Y" ).append("\n"); 
		query.append("   WHERE X.CNTR_TPSZ_CD = Y.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("   GROUP BY  X.MLB, X.POD_CD" ).append("\n"); 
		query.append("   ORDER BY 1" ).append("\n"); 

	}
}