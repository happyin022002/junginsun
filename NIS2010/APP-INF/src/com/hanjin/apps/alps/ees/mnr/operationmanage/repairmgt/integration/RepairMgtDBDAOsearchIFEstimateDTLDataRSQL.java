/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : RepairMgtDBDAOsearchIFEstimateDTLDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.11
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOsearchIFEstimateDTLDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchIFEstimateDTLData
	  * -- COST CODE 추출로직 보강, 2014-07-15, 신용찬
	  * </pre>
	  */
	public RepairMgtDBDAOsearchIFEstimateDTLDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rqst_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOsearchIFEstimateDTLDataRSQL").append("\n"); 
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
		query.append("SELECT   MRD.RQST_EQ_NO" ).append("\n"); 
		query.append("       , MRD.RPR_RQST_SEQ" ).append("\n"); 
		query.append("       , MRD.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("       , MRD.RPR_RQST_DTL_SEQ" ).append("\n"); 
		query.append("       , MRD.RPR_RQST_LST_VER_FLG" ).append("\n"); 
		query.append("       , MRD.EQ_LOC_CD" ).append("\n"); 
		query.append("       , MRD.EQ_LOC_CD_CHK_FLG" ).append("\n"); 
		query.append("       , MRD.EQ_CMPO_CD" ).append("\n"); 
		query.append("       , MRD.EQ_CMPO_CD_CHK_FLG" ).append("\n"); 
		query.append("       , MRD.EQ_DMG_CD" ).append("\n"); 
		query.append("       , MRD.EQ_DMG_CD_CHK_FLG" ).append("\n"); 
		query.append("       , MRD.EQ_RPR_CD" ).append("\n"); 
		query.append("       , MRD.EQ_RPR_CD_CHK_FLG" ).append("\n"); 
		query.append("       , MRD.TRF_DIV_CD" ).append("\n"); 
		query.append("       , MRD.TRF_OPT_CD" ).append("\n"); 
		query.append("       , MRD.VOL_TP_CD" ).append("\n"); 
		query.append("       , MRD.RPR_QTY" ).append("\n"); 
		query.append("       , MRD.RPR_SZ_NO" ).append("\n"); 
		query.append("       , MRD.RPR_LEN_NO" ).append("\n"); 
		query.append("       , MRD.RPR_WDT_NO" ).append("\n"); 
		query.append("       , MRD.RPR_LBR_HRS" ).append("\n"); 
		query.append("       , MRD.RPR_LBR_RT" ).append("\n"); 
		query.append("       , MRD.RPR_LBR_BZC_HRS" ).append("\n"); 
		query.append("       , MRD.RPR_LBR_BZC_RT" ).append("\n"); 
		query.append("       , MRD.MNR_LBR_BZC_AMT" ).append("\n"); 
		query.append("       , MRD.LBR_MTRL_BZC_AMT" ).append("\n"); 
		query.append("       , MRD.LBR_COST_AMT" ).append("\n"); 
		query.append("       , MRD.MTRL_COST_AMT" ).append("\n"); 
		query.append("       , MRD.XCH_MTRL_COST_AMT" ).append("\n"); 
		query.append("       , MRD.MTRL_RECO_AMT" ).append("\n"); 
		query.append("       , MRD.MNR_LR_ACCT_FLG" ).append("\n"); 
		query.append("       , MRD.N3PTY_FLG" ).append("\n"); 
		query.append("       , MRD.N3PTY_BIL_LBR_HRS" ).append("\n"); 
		query.append("       , MRD.N3PTY_BIL_LBR_RT" ).append("\n"); 
		query.append("       , MRD.N3PTY_BIL_LBR_COST_AMT" ).append("\n"); 
		query.append("       , MRD.N3PTY_BIL_MTRL_COST_AMT" ).append("\n"); 
		query.append("       , MRD.MNR_AGMT_AMT" ).append("\n"); 
		query.append("       , MRD.MNR_WRK_AMT" ).append("\n"); 
		query.append("       , MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC (TO_CHAR(SYSDATE, 'YYYYMM'), MRH.CURR_CD, 'USD', MRD.MNR_WRK_AMT) AS MNR_WRK_USD_AMT" ).append("\n"); 
		query.append("       , MRD.N3PTY_BIL_AMT" ).append("\n"); 
		query.append("       , MRD.RPR_DTL_RMK" ).append("\n"); 
		query.append("       , MRD.MNR_VRFY_TP_CD" ).append("\n"); 
		query.append("       , MRD.CRE_USR_ID" ).append("\n"); 
		query.append("       , TO_CHAR(MRD.CRE_DT, 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append("       , MRD.UPD_USR_ID" ).append("\n"); 
		query.append("       , TO_CHAR(MRD.UPD_DT, 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append("       , CASE WHEN MRH.EQ_KND_CD = 'G' THEN 'MRGSRC'" ).append("\n"); 
		query.append("              WHEN MRH.EQ_KND_CD = 'Z' THEN 'MRZSRC'" ).append("\n"); 
		query.append("              WHEN MRH.EQ_KND_CD = 'U' THEN (" ).append("\n"); 
		query.append("                                              SELECT   DECODE(SUBSTR(MRH.EQ_TPSZ_CD , 1, 1) ,'D', 'MRDRRC'         " ).append("\n"); 
		query.append("                                                                                            ,'R',  DECODE(MECD_2.EQ_PRNT_CMPO_CD, 'K6', 'MRRURC', 'MRRFRC')" ).append("\n"); 
		query.append("                                                                                                  ,'MRDSRC') AS COST_CD" ).append("\n"); 
		query.append("                                              FROM     MNR_EQ_CMPO_CD MECD_1" ).append("\n"); 
		query.append("                                                     , MNR_EQ_CMPO_CD MECD_2" ).append("\n"); 
		query.append("                                              WHERE    1 = 1" ).append("\n"); 
		query.append("                                              AND      MECD_1.EQ_CMPO_GRP_TP_CD = 3" ).append("\n"); 
		query.append("                                              AND      MECD_1.EQ_PRNT_CMPO_GRP_TP_CD = MECD_2.EQ_CMPO_GRP_TP_CD" ).append("\n"); 
		query.append("                                              AND      MECD_1.EQ_PRNT_CMPO_CD = MECD_2.EQ_CMPO_CD" ).append("\n"); 
		query.append("                                              AND      MECD_1.EQ_CMPO_CD = MRD.EQ_CMPO_CD" ).append("\n"); 
		query.append("                                              AND      SUBSTR(MECD_1.EQ_PRNT_CMPO_CD,1,2) IN ('K1','K4','K5','K6','K7') -- Container Cost Code 만 조회하도록 수정, 2014-07-15, 신용찬" ).append("\n"); 
		query.append("                                              AND      ROWNUM = 1                                     " ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("         END COST_CD " ).append("\n"); 
		query.append("       , 'NR' AS COST_DTL_CD" ).append("\n"); 
		query.append("FROM     MNR_RPR_RQST_DTL MRD" ).append("\n"); 
		query.append("       , MNR_RPR_RQST_HDR MRH" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      MRH.RQST_EQ_NO = MRD.RQST_EQ_NO" ).append("\n"); 
		query.append("AND      MRH.RPR_RQST_SEQ = MRD.RPR_RQST_SEQ" ).append("\n"); 
		query.append("AND      MRH.RPR_RQST_VER_NO = MRD.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("AND      MRD.RQST_EQ_NO      = @[rqst_eq_no]" ).append("\n"); 
		query.append("AND      MRD.RPR_RQST_SEQ    = @[rpr_rqst_seq]" ).append("\n"); 
		query.append("AND      MRD.RPR_RQST_VER_NO = @[rpr_rqst_ver_no]" ).append("\n"); 

	}
}