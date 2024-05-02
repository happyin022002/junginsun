/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SalesRPTDBDAOsearchBkg0061List2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRPTDBDAOsearchBkg0061List2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * _BKG_COST_SMRY, _BKG_INFO, _BKG_REV_DTL 테이블의 데이터 조회   
	  * </pre>
	  */
	public SalesRPTDBDAOsearchBkg0061List2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pro_lvl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pro_vw",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rout_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.integration").append("\n"); 
		query.append("FileName : SalesRPTDBDAOsearchBkg0061List2RSQL").append("\n"); 
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
		query.append("SELECT   DECODE(CPY_NO,1,'Load(Box)'" ).append("\n"); 
		query.append("                      , 2,'G.Rev'" ).append("\n"); 
		query.append("                      , 3,'G.RPB'" ).append("\n"); 
		query.append("                      , 4,'Misc OP Rev'" ).append("\n"); 
		query.append("                      , 5,'DEM/DET'" ).append("\n"); 
		query.append("                      , 6,'CM(EPP-A)'" ).append("\n"); 
		query.append("                      , 7,'CM(EPP-A)'||' Per Box'" ).append("\n"); 
		query.append("					  , 8,'CM(EPP-B)'" ).append("\n"); 
		query.append("					  , 9,'CM(EPP-B)'||' Per Box') AS T1" ).append("\n"); 
		query.append("#set ($val = 0)" ).append("\n"); 
		query.append("#foreach( $key in ${f_tpsz}) " ).append("\n"); 
		query.append("#set ($val = $val + 1) " ).append("\n"); 
		query.append("         , SUM(DECODE(CNTR_TPSZ_CD,'$key',DECODE(CPY_NO,1,LOAD" ).append("\n"); 
		query.append("                                                       , 2,G_REV " ).append("\n"); 
		query.append("                                                       , 3,G_REV / LOAD" ).append("\n"); 
		query.append("                                                       , 4,MISC_REV" ).append("\n"); 
		query.append("                                                       , 5,DEM" ).append("\n"); 
		query.append("                                                       , 6,CM" ).append("\n"); 
		query.append("                                                       , 7,CM / LOAD" ).append("\n"); 
		query.append("													   , 8,CM2" ).append("\n"); 
		query.append("                                                       , 9,CM2 / LOAD)" ).append("\n"); 
		query.append("                                  , 0)) AS B${val}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM     (SELECT   CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                   , SUM(LOAD)     LOAD" ).append("\n"); 
		query.append("                   , SUM(G_REV)    G_REV" ).append("\n"); 
		query.append("                   , SUM(MISC_REV) MISC_REV" ).append("\n"); 
		query.append("                   , SUM(CM)       CM" ).append("\n"); 
		query.append("                   , SUM(DEM)      DEM" ).append("\n"); 
		query.append("                   , SUM(CM2)      CM2" ).append("\n"); 
		query.append("          FROM     (SELECT   A2.SPCL_CNTR_TPSZ_CD                                                                                                                AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                             , SUM(A2.BKG_QTY)                                                                                                                   LOAD" ).append("\n"); 
		query.append("                             , SUM(NVL(A2.BKG_REV,0) + NVL(A2.BKG_OFT_REV,0))                                                                                    G_REV" ).append("\n"); 
		query.append("                             , SUM(NVL(A2.BKG_MISC_REV,0) + NVL(A2.SCR_CHG_REV,0))                                                                               MISC_REV" ).append("\n"); 
		query.append("                             , SUM(NVL(A2.BKG_REV,0) + NVL(A2.BKG_OFT_REV,0) + NVL(A2.BKG_MISC_REV,0) + NVL(A2.SCR_CHG_REV,0)) - SUM(DECODE(@[f_pro_vw]||@[f_pro_lvl]" ).append("\n"); 
		query.append("                                                                                                                                                           , 'PC',NVL(A2.ESTM_CM_COST_AMT,0)" ).append("\n"); 
		query.append("                                                                                                                                                           , 'PO',NVL(A2.ESTM_CM_COST_AMT,0)" ).append("\n"); 
		query.append("																																															-- + NVL(A2.ESTM_OPFIT_COST_AMT,0) /*CHM-200901045 Trade profit - OP 선택 시 OP 계정이 CM에 계산 되어 반영 되는 부분  쿼리수정 [061]*/" ).append("\n"); 
		query.append("                                                                                                                                                           , 'RC',NVL(A2.RA_CM_COST_AMT,0)" ).append("\n"); 
		query.append("                                                                                                                                                           , 'RO',NVL(A2.RA_CM_COST_AMT,0) + NVL(A2.RA_OPFIT_COST_AMT,0)" ).append("\n"); 
		query.append("                                                                                                                                                           , 0)) CM" ).append("\n"); 
		query.append("							 , SUM(NVL(A2.BKG_REV,0) + NVL(A2.BKG_OFT_REV,0) + NVL(A2.BKG_MISC_REV,0) + NVL(A2.SCR_CHG_REV,0)) - SUM(DECODE(@[f_pro_vw]||@[f_pro_lvl]" ).append("\n"); 
		query.append("                                                                                                                                                           , 'PC',NVL(A2.ESTM_CM_COST_AMT2,0)" ).append("\n"); 
		query.append("                                                                                                                                                           , 'PO',NVL(A2.ESTM_CM_COST_AMT2,0)" ).append("\n"); 
		query.append("																																															-- + NVL(A2.ESTM_OPFIT_COST_AMT,0) /*CHM-200901045 Trade profit - OP 선택 시 OP 계정이 CM에 계산 되어 반영 되는 부분  쿼리수정 [061]*/" ).append("\n"); 
		query.append("                                                                                                                                                           , 'RC',NVL(A2.RA_CM_COST_AMT,0)" ).append("\n"); 
		query.append("                                                                                                                                                           , 'RO',NVL(A2.RA_CM_COST_AMT,0) + NVL(A2.RA_OPFIT_COST_AMT,0)" ).append("\n"); 
		query.append("                                                                                                                                                           , 0)) CM2" ).append("\n"); 
		query.append("                             , SUM(A1.DMDT_COM_AMT)                                                                                                              DEM" ).append("\n"); 
		query.append("                    FROM     COA_BKG_EXPN_DTL A1" ).append("\n"); 
		query.append("                             , COA_BKG_REV_DTL A2" ).append("\n"); 
		query.append("                    WHERE    1 = 1" ).append("\n"); 
		query.append("                    AND A1.BKG_NO = @[f_bkg_no]" ).append("\n"); 
		query.append("                    AND a1.bl_no_tp           IN ('M','0')" ).append("\n"); 
		query.append("                    AND A1.BKG_STS_CD IN ('F','S','W')" ).append("\n"); 
		query.append("                    AND A1.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("                    AND A1.BKG_NO = A2.BKG_NO (+)" ).append("\n"); 
		query.append("                    AND A1.CNTR_TPSZ_CD = A2.CNTR_TPSZ_CD (+)" ).append("\n"); 
		query.append("                    AND A1.COST_ROUT_NO = A2.COST_ROUT_NO (+)" ).append("\n"); 
		query.append("#if (${f_rout_no} != 'All') " ).append("\n"); 
		query.append("                    AND A2.COST_ROUT_NO (+)  = @[f_rout_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                    GROUP BY A2.SPCL_CNTR_TPSZ_CD) " ).append("\n"); 
		query.append("          GROUP BY CNTR_TPSZ_CD) X" ).append("\n"); 
		query.append("         , (SELECT CPY_NO" ).append("\n"); 
		query.append("          FROM   COM_CPY_NO" ).append("\n"); 
		query.append("          WHERE  CPY_NO BETWEEN 1 AND 9) Y" ).append("\n"); 
		query.append("GROUP BY CPY_NO" ).append("\n"); 
		query.append("ORDER BY CPY_NO" ).append("\n"); 

	}
}