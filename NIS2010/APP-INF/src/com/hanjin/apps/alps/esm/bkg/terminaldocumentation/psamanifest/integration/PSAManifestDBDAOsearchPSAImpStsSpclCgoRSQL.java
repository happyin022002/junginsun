/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PSAManifestDBDAOsearchPSAImpStsSpclCgoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.09
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.02.09 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOsearchPSAImpStsSpclCgoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSA Import Status Special Cargo의 정보를 조회한다. 아래 조건에서 조회되지 않으면 BKG에서 Special Cargo정보를 조회한다.
	  * </pre>
	  */
	public PSAManifestDBDAOsearchPSAImpStsSpclCgoRSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : PSAManifestDBDAOsearchPSAImpStsSpclCgoRSQL").append("\n"); 
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
		query.append("SELECT PISS.DCGO_FLG DCGO_FLG" ).append("\n"); 
		query.append(", PISS.RC_FLG RC_FLG" ).append("\n"); 
		query.append(", PISS.AWK_CGO_FLG AWK_CGO_FLG" ).append("\n"); 
		query.append(", PISS.BB_CGO_FLG BB_CGO_FLG" ).append("\n"); 
		query.append(", PISS.RD_CGO_FLG RD_CGO_FLG" ).append("\n"); 
		query.append(", PISS.RC_TEMP RF_FLG" ).append("\n"); 
		query.append(", PISS.OVR_DIM_HGT OVR_DIM_HGT" ).append("\n"); 
		query.append(", PISS.OVR_FNT_DIM_LEN OVR_FNT_DIM_LEN" ).append("\n"); 
		query.append(", PISS.OVR_BAK_DIM_LEN OVR_BAK_DIM_LEN" ).append("\n"); 
		query.append(", PISS.OVR_LF_DIM_WDT OVR_LF_DIM_WDT" ).append("\n"); 
		query.append(", PISS.OVR_RT_DIM_WDT OVR_RT_DIM_WDT" ).append("\n"); 
		query.append(", PISS.DIM_LEN DIM_LEN" ).append("\n"); 
		query.append(", PISS.DIM_WDT DIM_WDT" ).append("\n"); 
		query.append(", PISS.DIM_HGT DIM_HGT" ).append("\n"); 
		query.append(", NVL(PISS.CGO_DESC, CO.CMDT_NM) CGO_DESC" ).append("\n"); 
		query.append(", NVL(PISS.CMDT_DESC, CO.CMDT_NM) CMDT_DESC" ).append("\n"); 
		query.append(", NVL(SUBSTR(PISS.PSA_STWG_TP_ID,1,2), '  ') LD_INS1" ).append("\n"); 
		query.append(", NVL(SUBSTR(PISS.PSA_STWG_TP_ID,3,2), '  ') LD_INS2" ).append("\n"); 
		query.append(", NVL(SUBSTR(PISS.PSA_STWG_TP_ID,5,2), '  ') LD_INS3" ).append("\n"); 
		query.append(", PISS.DCHG_OVR_SZ_FLG DCHG_OVR_SZ_FLG" ).append("\n"); 
		query.append(", PISS.DIR_DE_FLG DIR_DE_FLG" ).append("\n"); 
		query.append(", ' ' USER_ID" ).append("\n"); 
		query.append(", PISS.VSL_CD VSL_CD" ).append("\n"); 
		query.append(", PISS.SKD_VOY_NO SKD_VOY_NO" ).append("\n"); 
		query.append(", PISS.SKD_DIR_CD SKD_DIR_CD" ).append("\n"); 
		query.append(", BK.BKG_NO BKG_NO" ).append("\n"); 
		query.append(", 'U' TYPE_CD" ).append("\n"); 
		query.append(", PISS.CNTR_NO CNTR_NO" ).append("\n"); 
		query.append("FROM   BKG_CSTMS_PSA_IMP_STS_SPCL PISS, MDM_COMMODITY CO, BKG_BOOKING BK" ).append("\n"); 
		query.append("WHERE  PISS.VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("AND    PISS.SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("AND    PISS.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND    PISS.CNTR_NO       = @[cntr_no]" ).append("\n"); 
		query.append("AND    BK.BKG_NO          = @[bkg_no]" ).append("\n"); 
		query.append("AND    BK.CMDT_CD         = CO.CMDT_CD" ).append("\n"); 

	}
}