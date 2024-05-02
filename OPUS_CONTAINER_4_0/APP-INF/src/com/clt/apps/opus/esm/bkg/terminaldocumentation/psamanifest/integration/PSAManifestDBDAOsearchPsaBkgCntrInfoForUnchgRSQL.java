/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PSAManifestDBDAOsearchPsaBkgCntrInfoForUnchgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.10
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.10.10 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOsearchPsaBkgCntrInfoForUnchgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [vvd_unchanged용]PSA BKG CNTR로 flat file을 만들기 위해 조회
	  * </pre>
	  */
	public PSAManifestDBDAOsearchPsaBkgCntrInfoForUnchgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bkg_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n"); 
		query.append("FileName : PSAManifestDBDAOsearchPsaBkgCntrInfoForUnchgRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT CNTR.PSA_SER_NO TPSZ_NO" ).append("\n"); 
		query.append("     , CNTR.PSA_IF_CD CNTR_FI" ).append("\n"); 
		query.append("       ,CASE WHEN CNTR.PSA_SER_NO-99*SUBSTR(CNTR.PSA_SER_NO,1,1)> 99 THEN LPAD(SUBSTR(CNTR.PSA_SER_NO-99*SUBSTR(CNTR.PSA_SER_NO,1,1),3,1)+1,2,'0')" ).append("\n"); 
		query.append("             WHEN CNTR.PSA_SER_NO-99*SUBSTR(CNTR.PSA_SER_NO,1,1)<=0  THEN LPAD(CNTR.PSA_SER_NO, 2, '0' ) " ).append("\n"); 
		query.append("             ELSE LPAD(CNTR.PSA_SER_NO-99*SUBSTR(CNTR.PSA_SER_NO,1,1),2,'0') END AS SEQ_CNTR" ).append("\n"); 
		query.append("     , CNTR.CNTR_TPSZ_CD CNTR_SZ" ).append("\n"); 
		query.append("     , CNTR.FULL_MTY_CD CNTR_ST" ).append("\n"); 
		query.append("     , CNTR.DCGO_FLG DG_IND" ).append("\n"); 
		query.append("     , CNTR.RC_FLG RF_IND" ).append("\n"); 
		query.append("     , CNTR.OVR_HGT_FLG OH_IND" ).append("\n"); 
		query.append("     , CNTR.OVR_WDT_FLG OW_IND" ).append("\n"); 
		query.append("     , CNTR.OVR_LEN_FLG OL_IND" ).append("\n"); 
		query.append("     , LPAD(CNTR.CNTR_KNT, 3, '0' ) NO_CNTR" ).append("\n"); 
		query.append("     , DECODE(CNTR.RD_CGO_FLG, 'Y','DRY', DECODE(CNTR.RC_FLG, 'Y', DECODE(SUBSTR(NVL(RC_TEMP,0),1,1),'-',TRIM(TO_CHAR(NVL(CNTR.RC_TEMP,0),'000.00'))||'C', '+'||TRIM(TO_CHAR(NVL(CNTR.RC_TEMP,0),'000.00'))||'C'), '')) RF_TEMP " ).append("\n"); 
		query.append("     , BK.STWG_CD AS SP_DTL" ).append("\n"); 
		query.append("     , CNTR.N1ST_CNTR_NO CNTR_NO1" ).append("\n"); 
		query.append("     , CNTR.N2ND_CNTR_NO CNTR_NO2" ).append("\n"); 
		query.append("     , CNTR.N3RD_CNTR_NO CNTR_NO3" ).append("\n"); 
		query.append("     , CNTR.N4TH_CNTR_NO CNTR_NO4" ).append("\n"); 
		query.append("     , CNTR.N5TH_CNTR_NO CNTR_NO5" ).append("\n"); 
		query.append("     , CNTR.N6TH_CNTR_NO CNTR_NO6" ).append("\n"); 
		query.append("     , CNTR.PSA_CNTR_HGT_CD CNTR_HEIGHT" ).append("\n"); 
		query.append("     , DECODE(TRIM(CNTR.HUMID_NO), NULL, CNTR.HUMID_NO, 0, NULL, LPAD(CNTR.HUMID_NO, 3, '0')) HUMID_NO" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_PSA_CNTR CNTR," ).append("\n"); 
		query.append("        BKG_STWG_CGO BK" ).append("\n"); 
		query.append("WHERE   CNTR.BKG_NO    = BK.BKG_NO(+)" ).append("\n"); 
		query.append("  AND   BK.STWG_SEQ(+) = 1" ).append("\n"); 
		query.append("  AND   CNTR.BKG_NO    = @[bkg_no]" ).append("\n"); 
		query.append("  AND   CNTR.BKG_SEQ   = @[bkg_seq]" ).append("\n"); 
		query.append("ORDER BY   CNTR.PSA_SER_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}