/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PSAManifestDBDAOsearchPsaBkgCntrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.30
*@LastModifier : 
*@LastVersion : 1.0
* 2010.08.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOsearchPsaBkgCntrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSA BKG CNTR로 flat file을 만들기 위해 조회
	  * </pre>
	  */
	public PSAManifestDBDAOsearchPsaBkgCntrInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n"); 
		query.append("FileName : PSAManifestDBDAOsearchPsaBkgCntrInfoRSQL").append("\n"); 
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
		query.append("SELECT CNTR.PSA_SER_NO TPSZ_NO" ).append("\n"); 
		query.append("     , 'D' CNTR_FI" ).append("\n"); 
		query.append("     , LPAD( CNTR.PSA_SER_NO, 2, '0' ) SEQ_CNTR" ).append("\n"); 
		query.append("     , CNTR.CNTR_TPSZ_CD CNTR_SZ" ).append("\n"); 
		query.append("     , CNTR.FULL_MTY_CD CNTR_ST" ).append("\n"); 
		query.append("     , DECODE( CNTR.DCGO_FLG,'1','Y',DECODE(BK.PRCT_FLG,'1','Y','N')) DG_IND" ).append("\n"); 
		query.append("     , DECODE( CNTR.RD_CGO_FLG, 'Y', 'Y', CNTR.RC_FLG ) RF_IND" ).append("\n"); 
		query.append("     , CNTR.OVR_HGT_FLG OH_IND" ).append("\n"); 
		query.append("     , CNTR.OVR_WDT_FLG OW_IND" ).append("\n"); 
		query.append("     , CNTR.OVR_LEN_FLG OL_IND" ).append("\n"); 
		query.append("     , LPAD( CNTR.CNTR_KNT, 3, '0' ) NO_CNTR" ).append("\n"); 
		query.append("     , DECODE( CNTR.RD_CGO_FLG, 'Y','DRY', DECODE(SUBSTR(NVL(RC_TEMP,0),1,1),'-',TRIM(TO_CHAR(NVL(CNTR.RC_TEMP,0),'000.00'))||'C','+'||TRIM(TO_CHAR(NVL(CNTR.RC_TEMP,0),'000.00'))||'C')) RF_TEMP" ).append("\n"); 
		query.append("     , DECODE(BK.STWG_CD,'AB','AB','OD','OD','ODAB','OD','ODET','OD','OT','ODTS','TS','TS','UD','UD','UDAB','UDAB',null) SP_DTL" ).append("\n"); 
		query.append("     , CNTR.N1ST_CNTR_NO CNTR_NO1" ).append("\n"); 
		query.append("     , CNTR.N2ND_CNTR_NO CNTR_NO2" ).append("\n"); 
		query.append("     , CNTR.N3RD_CNTR_NO CNTR_NO3" ).append("\n"); 
		query.append("     , CNTR.N4TH_CNTR_NO CNTR_NO4" ).append("\n"); 
		query.append("     , CNTR.N5TH_CNTR_NO CNTR_NO5" ).append("\n"); 
		query.append("     , CNTR.N6TH_CNTR_NO CNTR_NO6" ).append("\n"); 
		query.append("     , CNTR.PSA_CNTR_HGT_CD CNTR_HEIGHT" ).append("\n"); 
		query.append("	 , DECODE(TRIM(CNTR.HUMID_NO), NULL, CNTR.HUMID_NO, 0, NULL, LPAD(CNTR.HUMID_NO, 3, '0')) HUMID_NO" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_PSA_CNTR CNTR," ).append("\n"); 
		query.append("        BKG_BOOKING BK" ).append("\n"); 
		query.append("WHERE   CNTR.BKG_NO   = BK.BKG_NO" ).append("\n"); 
		query.append("  AND   CNTR.BKG_NO   = @[bkg_no]" ).append("\n"); 
		query.append("  AND   CNTR.BKG_SEQ  = @[bkg_seq] - 1" ).append("\n"); 
		query.append("ORDER BY   CNTR.PSA_SER_NO" ).append("\n"); 

	}
}