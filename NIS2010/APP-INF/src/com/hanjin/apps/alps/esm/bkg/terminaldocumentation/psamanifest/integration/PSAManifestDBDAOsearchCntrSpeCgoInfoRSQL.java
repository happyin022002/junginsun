/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PSAManifestDBDAOsearchCntrSpeCgoInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.08
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.02.08 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOsearchCntrSpeCgoInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CNTR 및 Special cargo정보를 조회한다.
	  * </pre>
	  */
	public PSAManifestDBDAOsearchCntrSpeCgoInfoRSQL(){
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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.integration ").append("\n"); 
		query.append("FileName : PSAManifestDBDAOsearchCntrSpeCgoInfoRSQL").append("\n"); 
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
		query.append("SELECT BC.CNTR_NO CNTR_NO" ).append("\n"); 
		query.append(", DECODE( BC.DCGO_FLG, '1', 'Y', 'N' ) SPE_DG" ).append("\n"); 
		query.append(", DECODE( BC.RC_FLG, '1', 'Y', 'N' ) SPE_RF" ).append("\n"); 
		query.append(", DECODE( BC.RD_CGO_FLG, '1', 'Y', 'N' ) SPE_RD" ).append("\n"); 
		query.append(", DECODE( BC.AWK_CGO_FLG, '1', 'Y', 'N' ) SPE_AK" ).append("\n"); 
		query.append(", DECODE( AC.CNTR_NO, NULL, 'N', 'Y' ) AK_EXIST" ).append("\n"); 
		query.append(", NVL( AC.OH_IND, 'N' ) OH_IND" ).append("\n"); 
		query.append(", NVL( AC.OW_IND, 'N' ) OW_IND" ).append("\n"); 
		query.append(", NVL( AC.OL_IND, 'N' ) OL_IND" ).append("\n"); 
		query.append(", DECODE( RC.CNTR_NO, NULL, 'N', 'Y' ) RF_EXIST" ).append("\n"); 
		query.append(", NVL( RC.RF_TEMP, 0  ) RF_TEMP" ).append("\n"); 
		query.append("FROM BKG_CONTAINER        BC" ).append("\n"); 
		query.append(", (   SELECT CNTR_NO" ).append("\n"); 
		query.append(", DECODE( NVL( MAX( OVR_HGT ), 0 ), 0, 'N', 'Y' ) OH_IND" ).append("\n"); 
		query.append(", DECODE( NVL( MAX( OVR_LF_LEN ) + MAX( OVR_RT_LEN ), 0 ), 0, 'N', 'Y' ) OW_IND" ).append("\n"); 
		query.append(", DECODE( NVL( MAX( OVR_FWRD_LEN )  + MAX( OVR_BKWD_LEN   ), 0 ), 0, 'N', 'Y' ) OL_IND" ).append("\n"); 
		query.append("FROM BKG_AWK_CGO" ).append("\n"); 
		query.append("WHERE BKG_NO  =   @[bkg_no]" ).append("\n"); 
		query.append("AND CNTR_NO IS  NOT NULL" ).append("\n"); 
		query.append("GROUP BY CNTR_NO ) AC" ).append("\n"); 
		query.append(", (   SELECT CNTR_NO" ).append("\n"); 
		query.append(", MIN( CDO_TEMP )    RF_TEMP" ).append("\n"); 
		query.append("FROM BKG_RF_CGO" ).append("\n"); 
		query.append("WHERE BKG_NO  =   @[bkg_no]" ).append("\n"); 
		query.append("AND CNTR_NO IS  NOT NULL" ).append("\n"); 
		query.append("GROUP BY CNTR_NO )   RC" ).append("\n"); 
		query.append("WHERE   AC.CNTR_NO(+)       =   BC.CNTR_NO" ).append("\n"); 
		query.append("AND     RC.CNTR_NO(+)       =   BC.CNTR_NO" ).append("\n"); 
		query.append("AND     BC.BKG_NO           =   @[bkg_no]" ).append("\n"); 
		query.append("AND     BC.CNTR_TPSZ_CD     =   @[cntr_tpsz_cd]" ).append("\n"); 

	}
}