/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PSAManifestDBDAOsearchPSACNTRInfoFlatFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.05 
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

public class PSAManifestDBDAOsearchPSACNTRInfoFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSA CNTR Information을 조회하여 Flat File을 만든다.
	  * </pre>
	  */
	public PSAManifestDBDAOsearchPSACNTRInfoFlatFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n"); 
		query.append("FileName : PSAManifestDBDAOsearchPSACNTRInfoFlatFileRSQL").append("\n"); 
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
		query.append("SELECT NVL(PS.TS_TP_CD,'') TS_TP_CD" ).append("\n"); 
		query.append("     , TO_CHAR(PS.SND_DT,'YYMMDDHH24MISS') SND_DT" ).append("\n"); 
		query.append("     , NVL(PS.CNTR_NO,'') CNTR_NO" ).append("\n"); 
		query.append("     , NVL(PS.BKG_NO,'') BKG_NO" ).append("\n"); 
		query.append("     , NVL(PS.FULL_MTY_CD,'') FULL_MTY_CD" ).append("\n"); 
		query.append("     , ROUND((CASE WHEN PS.VGM_WGT > 0 THEN NVL(PS.VGM_WGT,0) ELSE NVL(PS.CNTR_WGT,0) END),0) CNTR_WGT" ).append("\n"); 
		query.append("     /*, CASE WHEN PS.VGM_WGT > 0 THEN 'Y' ELSE 'N' END VGM_IND*/" ).append("\n"); 
		query.append("     , CASE WHEN  NVL(PS.VGM_WGT,0) >  0 OR  NVL(PS.CNTR_WGT,0) > 0 THEN 'Y' ELSE 'N' END VGM_IND" ).append("\n"); 
		query.append("     , NVL(PS.CNTR_OPR_CD,'') CNTR_OPR_CD" ).append("\n"); 
		query.append("     , NVL(PS.IB_SLT_OPR_CD,'') IB_SLT_OPR_CD" ).append("\n"); 
		query.append("     , DECODE(NVL(PC.RC_TEMP,'0'),0,'',DECODE( SIGN(PC.RC_TEMP), -1,TO_CHAR(-1 * ( -1 * TO_NUMBER(NVL(PC.RC_TEMP,'0'))),'099.99'),'+'|| TRIM(TO_CHAR(-1 * ( -1 * TO_NUMBER(NVL(PC.RC_TEMP,'0'))),'099.99')) ) || 'C') RC_TEMP" ).append("\n"); 
		query.append("     , NVL(PS.DCGO_FLG,'') DCGO_FLG" ).append("\n"); 
		query.append("     , DECODE(NVL(PC.OVR_DIM_HGT,0),   0,'',LPAD(TRUNC(10*NVL(PC.OVR_DIM_HGT  ,0)),4,'0')||'C') OVR_DIM_HGT" ).append("\n"); 
		query.append("     , DECODE(NVL(PC.OVR_FNT_DIM_LEN,0), 0,'',LPAD(TRUNC(10*NVL(PC.OVR_FNT_DIM_LEN,0)),4,'0')||'C') OVR_FNT_DIM_LEN" ).append("\n"); 
		query.append("     , DECODE(NVL(PC.OVR_BAK_DIM_LEN,0), 0,'',LPAD(TRUNC(10*NVL(PC.OVR_BAK_DIM_LEN,0)),4,'0')||'C') OVR_BAK_DIM_LEN" ).append("\n"); 
		query.append("     , DECODE(NVL(PC.OVR_LF_DIM_WDT,0), 0,'',LPAD(TRUNC(10*NVL(PC.OVR_LF_DIM_WDT,0)),4,'0')||'C') OVR_LF_DIM_WDT" ).append("\n"); 
		query.append("     , DECODE(NVL(PC.OVR_RT_DIM_WDT,0), 0,'',LPAD(TRUNC(10*NVL(PC.OVR_RT_DIM_WDT,0)),4,'0')||'C') OVR_RT_DIM_WDT" ).append("\n"); 
		query.append("     , NVL(PC.DIM_HGT,'') DIM_HGT" ).append("\n"); 
		query.append("     , NVL(PC.DIM_WDT,'') DIM_WDT" ).append("\n"); 
		query.append("     , NVL(PC.DIM_LEN,'') DIM_LEN" ).append("\n"); 
		query.append("     , NVL(PC.CGO_DESC,'') CGO_DESC" ).append("\n"); 
		query.append("     , NVL(PC.CFS_TP_CD,'') CFS_TP_CD" ).append("\n"); 
		query.append("     , NVL(PC.DPT_SVC_TP_CD,'') DPT_SVC_TP_CD" ).append("\n"); 
		query.append("     , NVL(PC.RF_CNTR_PRE_TRD_INSP_TP_CD,'') RF_CNTR_PRE_TRD_INSP_TP_CD" ).append("\n"); 
		query.append("     , NVL(PC.PSA_STWG_TP_ID,'') STWG_TP_CD" ).append("\n"); 
		query.append("     , NVL(PS.OB_SLT_OPR_CD,'') OB_SLT_OPR_CD" ).append("\n"); 
		query.append("     , NVL(PS.PSA_BAT_NO,'') PSA_BAT_NO" ).append("\n"); 
		query.append("     ,(SELECT PSA_LOC_CD FROM BKG_CSTMS_PSA_PORT WHERE LOC_CD = NVL(PS.N1ST_POD_CD,'') AND ROWNUM = 1) N1ST_POD_CD" ).append("\n"); 
		query.append("     , NVL(PS.POD_CD,'') POD_CD" ).append("\n"); 
		query.append("     , NVL(PS.POL_CD,'') POL_CD" ).append("\n"); 
		query.append("     , NVL(PC.DCHG_OVR_SZ_FLG,'') DCHG_OVR_SZ_FLG" ).append("\n"); 
		query.append("     , NVL(PC.DIR_DE_FLG,'') DIR_DE_FLG" ).append("\n"); 
		query.append("     , REPLACE(NVL(PS.CNTR_SEAL_NO,''), '/', '') CNTR_SEAL_NO" ).append("\n"); 
		query.append("     , UPPER(PV.PSA_VSL_NM) PSA_VSL_NM" ).append("\n"); 
		query.append("     , PV.PSA_VOY_DIR_CD PSA_VOY_DIR_CD" ).append("\n"); 
		query.append("     , PS.VGM_MZD_TP_CD" ).append("\n"); 
		query.append("     , PS.VGM_VRFY_SIG_CTNT" ).append("\n"); 
		query.append("     , ' ' VGM_REF_NO" ).append("\n"); 
		query.append("     , NVL(TO_CHAR(PS.VGM_VRFY_DT, 'CCYYMMDDHHMM'),'') VGM_VRFY_DT" ).append("\n"); 
		query.append("FROM   BKG_CSTMS_PSA_VVD PV, BKG_CSTMS_PSA_IMP_STS PS, BKG_CSTMS_PSA_IMP_STS_SPCL PC, BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("WHERE  PS.VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("AND    PS.SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("AND    PS.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND    PS.LODG_VSL_CD    = PV.VSL_CD(+)" ).append("\n"); 
		query.append("AND    PS.LODG_SKD_VOY_NO = PV.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND    PS.LODG_VSL_DIR_CD  = PV.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND    PS.VSL_CD        = PC.VSL_CD (+)" ).append("\n"); 
		query.append("AND    PS.SKD_VOY_NO    = PC.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("AND    PS.SKD_DIR_CD    = PC.SKD_DIR_CD (+)" ).append("\n"); 
		query.append("AND    PS.CNTR_NO       = PC.CNTR_NO (+)" ).append("\n"); 
		query.append("AND    PS.BKG_NO        = CNTR.BKG_NO (+)" ).append("\n"); 
		query.append("AND    PS.CNTR_NO       = CNTR.CNTR_NO (+)" ).append("\n"); 

	}
}