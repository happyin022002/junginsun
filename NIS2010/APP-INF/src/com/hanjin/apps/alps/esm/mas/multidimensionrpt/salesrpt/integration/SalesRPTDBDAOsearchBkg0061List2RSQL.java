/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SalesRPTDBDAOsearchBkg0061List2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
	  * 2015.03.23 [CHM-201534153] 김시몬 CM/OP계정 추가 및 변경에 따라 보완
	  * 2015.04.22 [CHM-201534153] 김시몬 Dem/Det CM계정관련 수정
	  * 2017.06.01 [CSR #1026] 김동호 CM(BKG), CMPB(BKG) 추가
	  * 2017.11.20 [CSR #2557] 김동호 CM(BKG), CMPB(BKG) 제거
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
		params.put("f_rout_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.integration").append("\n"); 
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
		query.append("					  , 3,'G. Rev Per Box'" ).append("\n"); 
		query.append("					  , 4,'G.RPB'  -- 신규항목" ).append("\n"); 
		query.append("                      , 5,'Misc OP Rev'" ).append("\n"); 
		query.append("                      , 6,'DEM/DET'" ).append("\n"); 
		query.append("                      , 7,DECODE('C','O',DECODE('P','P','CM', 'OP'), 'M','CM2','CM')" ).append("\n"); 
		query.append("                      , 8,DECODE('C','O',DECODE('P','P','CM', 'OP'), 'M','CM2','CM')||' Per Box'" ).append("\n"); 
		query.append("                      , 9,'CMPB' -- 신규항목" ).append("\n"); 
		query.append("                      --, 10,'CM(BKG)' -- 신규항목(2017/06/01)" ).append("\n"); 
		query.append("                      --, 11,'CMPB(BKG)' -- 신규항목(2017/06/01)" ).append("\n"); 
		query.append("#if (${f_pro_lvl} == 'O')                     " ).append("\n"); 
		query.append("                      , 10,'OP'" ).append("\n"); 
		query.append("                      , 11,'OP(EX. Interest)'" ).append("\n"); 
		query.append("                      , 12,'OP Per Box'" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("                      ) AS T1" ).append("\n"); 
		query.append("#set ($val = 0)" ).append("\n"); 
		query.append("#foreach( $key in ${f_tpsz})" ).append("\n"); 
		query.append("#set ($val = $val + 1)" ).append("\n"); 
		query.append("         , SUM(DECODE(CNTR_TPSZ_CD,'$key',DECODE(CPY_NO,1,LOAD" ).append("\n"); 
		query.append("                                                       , 2,G_REV" ).append("\n"); 
		query.append("                                                       , 3,G_REV / LOAD" ).append("\n"); 
		query.append("                                                       , 4,(CASE WHEN SUBSTR('$key',-1) >= 4 THEN (G_REV / LOAD) / 2" ).append("\n"); 
		query.append("																ELSE G_REV / LOAD" ).append("\n"); 
		query.append("															END)" ).append("\n"); 
		query.append("                                                       , 5,MISC_REV" ).append("\n"); 
		query.append("                                                       , 6,DEM" ).append("\n"); 
		query.append("                                                       , 7,CM" ).append("\n"); 
		query.append("                                                       , 8,CM / LOAD" ).append("\n"); 
		query.append("                                                       , 9,(CASE WHEN SUBSTR('$key',-1) >= 4 THEN (CM / LOAD) / 2" ).append("\n"); 
		query.append("																ELSE CM / LOAD" ).append("\n"); 
		query.append("															END)" ).append("\n"); 
		query.append("                                                     --  , 10,CM_BKG" ).append("\n"); 
		query.append("                                                     --  , 11,(CASE WHEN SUBSTR('$key',-1) >= 4 THEN (CM_BKG / LOAD) / 2" ).append("\n"); 
		query.append("													 --		        ELSE CM_BKG / LOAD" ).append("\n"); 
		query.append("													 --		END)     " ).append("\n"); 
		query.append("										#if (${f_pro_lvl} == 'O')" ).append("\n"); 
		query.append("													   , 10,OP" ).append("\n"); 
		query.append("													   , 11,OP_EX" ).append("\n"); 
		query.append("                                                       , 12,OP / LOAD" ).append("\n"); 
		query.append("                                        #end		" ).append("\n"); 
		query.append("													   )" ).append("\n"); 
		query.append("                                  , 0)) AS B${val}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM     (SELECT   CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                   , SUM(LOAD)     LOAD" ).append("\n"); 
		query.append("                   , SUM(G_REV)    G_REV" ).append("\n"); 
		query.append("                   , SUM(MISC_REV) MISC_REV" ).append("\n"); 
		query.append("                   , SUM(CM)       CM" ).append("\n"); 
		query.append("                   , SUM(DEM)      DEM" ).append("\n"); 
		query.append("                   , SUM(CM_BKG)   CM_BKG" ).append("\n"); 
		query.append("                   , SUM(OP)       OP" ).append("\n"); 
		query.append("                   , SUM(OP_EX)    OP_EX" ).append("\n"); 
		query.append("          FROM     (SELECT   A2.SPCL_CNTR_TPSZ_CD	AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                             , SUM(A2.BKG_QTY)	LOAD" ).append("\n"); 
		query.append("                             , SUM(NVL(A2.BKG_REV,0) + NVL(A2.BKG_OFT_REV,0))	G_REV" ).append("\n"); 
		query.append("                             , SUM(NVL(A2.BKG_MISC_REV,0) + NVL(A2.SCR_CHG_REV,0))	MISC_REV" ).append("\n"); 
		query.append("                             , SUM(NVL(A2.BKG_REV,0) + NVL(A2.BKG_OFT_REV,0) + NVL(A2.BKG_MISC_REV,0) + NVL(A2.SCR_CHG_REV,0) + NVL(A1.DMDT_COM_AMT,0)) " ).append("\n"); 
		query.append("								- SUM(DECODE(@[f_pro_vw]||@[f_pro_lvl], 'PC',NVL(A2.ESTM_CM_COST_AMT,0)" ).append("\n"); 
		query.append("																	  , 'PO',NVL(A2.ESTM_CM_COST_AMT,0) -- + NVL(A2.ESTM_OPFIT_COST_AMT,0) /*CHM-200901045 Trade profit - OP 선택 시 OP 계정이 CM에 계산 되어 반영 되는 부분  쿼리수정 [061]*/" ).append("\n"); 
		query.append("																	  , 'PM',NVL(A2.ESTM_CM_COST_AMT,0) + NVL(A1.OWN_FDR_AMT,0)" ).append("\n"); 
		query.append("																	  , 'RC',NVL(A2.RA_CM_COST_AMT,0)" ).append("\n"); 
		query.append("																	  , 'RM',NVL(A2.RA_CM_COST_AMT,0) + NVL(A1.OWN_FDR_AMT,0)" ).append("\n"); 
		query.append("																	  , 'RO',NVL(A2.RA_CM_COST_AMT,0) + NVL(A2.RA_OPFIT_COST_AMT,0)" ).append("\n"); 
		query.append("																	  , 0))   AS CM" ).append("\n"); 
		query.append("                             , SUM(NVL(A2.BKG_REV,0) + NVL(A2.BKG_OFT_REV,0) + NVL(A2.BKG_MISC_REV,0) + NVL(A2.SCR_CHG_REV,0)) " ).append("\n"); 
		query.append("								- SUM(DECODE(@[f_pro_vw]||@[f_pro_lvl], 'PC',NVL(A2.ESTM_CM_COST_AMT,0)" ).append("\n"); 
		query.append("																	  , 'PO',NVL(A2.ESTM_CM_COST_AMT,0)" ).append("\n"); 
		query.append("																	  , 'PM',NVL(A2.ESTM_CM_COST_AMT,0) + NVL(A1.OWN_FDR_AMT,0)" ).append("\n"); 
		query.append("																	  , 'RC',NVL(A2.RA_CM_COST_AMT,0)" ).append("\n"); 
		query.append("																	  , 'RM',NVL(A2.RA_CM_COST_AMT,0) + NVL(A1.OWN_FDR_AMT,0)" ).append("\n"); 
		query.append("																	  , 'RO',NVL(A2.RA_CM_COST_AMT,0) + NVL(A2.RA_OPFIT_COST_AMT,0)" ).append("\n"); 
		query.append("																	  , 0))   " ).append("\n"); 
		query.append("                                + SUM(NVL(A1.CNTR_STERM_RNTL_LAND_AMT, 0) + NVL(A1.CNTR_LTERM_RNTL_LAND_AMT, 0) + NVL(A1.CNTR_MNR_LAND_AMT, 0) " ).append("\n"); 
		query.append("                                        + NVL(A1.CNTR_DPC_LAND_AMT, 0) + NVL(A1.CNTR_INSUR_LAND_AMT, 0) + NVL(A1.CNTR_STERM_RNTL_OTR_AMT, 0) " ).append("\n"); 
		query.append("                                        + NVL(A1.CNTR_LTERM_RNTL_OTR_AMT, 0) + NVL(A1.CNTR_MNR_OTR_AMT, 0) + NVL(A1.CNTR_DPC_OTR_AMT, 0) " ).append("\n"); 
		query.append("                                        + NVL(A1.CNTR_INSUR_OTR_AMT, 0) + NVL(A1.CHSS_AMT, 0)" ).append("\n"); 
		query.append("                                        + NVL(A1.CNTR_RNTL_NORM_AMT, 0) + NVL(A1.CNTR_MNR_NORM_AMT, 0) " ).append("\n"); 
		query.append("                                        + NVL(A1.CNTR_DPC_NORM_AMT, 0) + NVL(A1.CNTR_INSUR_NORM_AMT, 0)) AS CM_BKG -- CM(BKG)는 CM 중 수입에서 DEM/DET, 비용에서 장비비 제외" ).append("\n"); 
		query.append("                             , SUM(A1.DMDT_COM_AMT)	DEM" ).append("\n"); 
		query.append("                             , SUM(NVL(A2.BKG_REV,0) + NVL(A2.BKG_OFT_REV,0) + NVL(A2.BKG_MISC_REV,0) + NVL(A2.SCR_CHG_REV,0) + NVL(A1.DMDT_COM_AMT,0)) " ).append("\n"); 
		query.append("								- SUM(DECODE('R'||'O', 'PC',NVL(A2.ESTM_CM_COST_AMT,0)" ).append("\n"); 
		query.append("																	  , 'PO',NVL(A2.ESTM_CM_COST_AMT,0) -- + NVL(A2.ESTM_OPFIT_COST_AMT,0) /*CHM-200901045 Trade profit - OP 선택 시 OP 계정이 CM에 계산 되어 반영 되는 부분  쿼리수정 [061]*/" ).append("\n"); 
		query.append("																	  , 'PM',NVL(A2.ESTM_CM_COST_AMT,0) + NVL(A1.OWN_FDR_AMT,0)" ).append("\n"); 
		query.append("																	  , 'RC',NVL(A2.RA_CM_COST_AMT,0)" ).append("\n"); 
		query.append("																	  , 'RM',NVL(A2.RA_CM_COST_AMT,0) + NVL(A1.OWN_FDR_AMT,0)" ).append("\n"); 
		query.append("																	  , 'RO',NVL(A2.RA_CM_COST_AMT,0) + NVL(A2.RA_OPFIT_COST_AMT,0)" ).append("\n"); 
		query.append("																	  , 0)) - NVL(SUM(A6.PA_OP_COST_TTL_AMT),0) AS OP" ).append("\n"); 
		query.append("	                         , SUM(NVL(A2.BKG_REV,0) + NVL(A2.BKG_OFT_REV,0) + NVL(A2.BKG_MISC_REV,0) + NVL(A2.SCR_CHG_REV,0) + NVL(A1.DMDT_COM_AMT,0)) " ).append("\n"); 
		query.append("								- SUM(DECODE('R'||'O', 'PC',NVL(A2.ESTM_CM_COST_AMT,0)" ).append("\n"); 
		query.append("																	  , 'PO',NVL(A2.ESTM_CM_COST_AMT,0) -- + NVL(A2.ESTM_OPFIT_COST_AMT,0) /*CHM-200901045 Trade profit - OP 선택 시 OP 계정이 CM에 계산 되어 반영 되는 부분  쿼리수정 [061]*/" ).append("\n"); 
		query.append("																	  , 'PM',NVL(A2.ESTM_CM_COST_AMT,0) + NVL(A1.OWN_FDR_AMT,0)" ).append("\n"); 
		query.append("																	  , 'RC',NVL(A2.RA_CM_COST_AMT,0)" ).append("\n"); 
		query.append("																	  , 'RM',NVL(A2.RA_CM_COST_AMT,0) + NVL(A1.OWN_FDR_AMT,0)" ).append("\n"); 
		query.append("																	  , 'RO',NVL(A2.RA_CM_COST_AMT,0) + NVL(A2.RA_OPFIT_COST_AMT,0)" ).append("\n"); 
		query.append("																	  , 0)) - NVL(SUM(A6.PA_OP_COST_TTL_AMT),0) + NVL(SUM(A6.VSL_INT_AMT),0) AS OP_EX" ).append("\n"); 
		query.append("                    FROM     MAS_BKG_EXPN_DTL    A1" ).append("\n"); 
		query.append("                            ,MAS_BKG_REV_DTL     A2" ).append("\n"); 
		query.append("                            ,MAS_BKG_OP_EXPN_DTL A6" ).append("\n"); 
		query.append("                    WHERE    1 = 1" ).append("\n"); 
		query.append("                    AND A1.BKG_NO         = @[f_bkg_no]" ).append("\n"); 
		query.append("                    AND a1.bl_no_tp      IN ('M','0')" ).append("\n"); 
		query.append("                    AND A1.BKG_STS_CD    IN ('F','S','W')" ).append("\n"); 
		query.append("                    AND A1.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("                    AND A1.BKG_NO         = A2.BKG_NO (+)" ).append("\n"); 
		query.append("                    AND A1.CNTR_TPSZ_CD   = A2.CNTR_TPSZ_CD (+)" ).append("\n"); 
		query.append("                    AND A1.COST_ROUT_NO   = A2.COST_ROUT_NO (+)" ).append("\n"); 
		query.append("                    AND A1.BKG_NO         = A6.BKG_NO (+)" ).append("\n"); 
		query.append("                    AND A1.CNTR_TPSZ_CD   = A6.CNTR_TPSZ_CD (+)" ).append("\n"); 
		query.append("                    AND A1.COST_ROUT_NO   = A6.COST_ROUT_NO (+)" ).append("\n"); 
		query.append("#if (${f_rout_no} != 'All') " ).append("\n"); 
		query.append("                    AND A2.COST_ROUT_NO (+)  = @[f_rout_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                    GROUP BY A2.SPCL_CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("          GROUP BY CNTR_TPSZ_CD) X" ).append("\n"); 
		query.append("         , (SELECT CPY_NO" ).append("\n"); 
		query.append("          FROM   COM_CPY_NO" ).append("\n"); 
		query.append("          WHERE  CPY_NO BETWEEN 1 AND " ).append("\n"); 
		query.append("          #if (${f_pro_lvl} == 'O')" ).append("\n"); 
		query.append("              12" ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("              9" ).append("\n"); 
		query.append("          #end " ).append("\n"); 
		query.append("          ) Y" ).append("\n"); 
		query.append("GROUP BY CPY_NO" ).append("\n"); 
		query.append("ORDER BY CPY_NO" ).append("\n"); 

	}
}