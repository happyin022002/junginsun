/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PSAManifestDBDAOsearchBKGImpStsSpclCgoRSQL.java
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

public class PSAManifestDBDAOsearchBKGImpStsSpclCgoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSA table에서 Import Status Special Cargo의 정보가 없을 경우에는 BKG과 Special Cargo 테이블에서 정보를 조회한다.
	  * </pre>
	  */
	public PSAManifestDBDAOsearchBKGImpStsSpclCgoRSQL(){
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
		query.append("FileName : PSAManifestDBDAOsearchBKGImpStsSpclCgoRSQL").append("\n"); 
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
		query.append("SELECT A.OVR_HGT OVR_DIM_HGT" ).append("\n"); 
		query.append(", A.OVR_FWRD_LEN OVR_FNT_DIM_LEN" ).append("\n"); 
		query.append(", A.OVR_BKWD_LEN OVR_BAK_DIM_LEN" ).append("\n"); 
		query.append(", A.OVR_LF_LEN OVR_LF_DIM_WDT" ).append("\n"); 
		query.append(", A.OVR_RT_LEN OVR_RT_DIM_WDT" ).append("\n"); 
		query.append(", A.TTL_DIM_HGT DIM_HGT" ).append("\n"); 
		query.append(", A.TTL_DIM_WDT DIM_WDT" ).append("\n"); 
		query.append(", A.TTL_DIM_LEN DIM_LEN" ).append("\n"); 
		query.append(", R.CDO_TEMP RF_FLG" ).append("\n"); 
		query.append(", CO.CMDT_NM CMDT_DESC" ).append("\n"); 
		query.append(", 'I' TYPE_CD" ).append("\n"); 
		query.append(", CO.CMDT_NM CGO_DESC" ).append("\n"); 
		query.append(", C.CNTR_NO CNTR_NO" ).append("\n"); 
		query.append(", C.BKG_NO BKG_NO" ).append("\n"); 
		query.append(", @[vsl_cd] VSL_CD" ).append("\n"); 
		query.append(", @[skd_voy_no] SKD_VOY_NO" ).append("\n"); 
		query.append(", @[skd_dir_cd] SKD_DIR_CD" ).append("\n"); 
		query.append("FROM  BKG_AWK_CGO A, BKG_RF_CGO R, BKG_CONTAINER C, BKG_BOOKING B, MDM_COMMODITY CO" ).append("\n"); 
		query.append("WHERE C.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND   C.CNTR_NO      = @[cntr_no]" ).append("\n"); 
		query.append("AND   C.BKG_NO       = A.BKG_NO (+)" ).append("\n"); 
		query.append("AND   C.CNTR_NO      = A.CNTR_NO (+)" ).append("\n"); 
		query.append("AND   C.BKG_NO       = R.BKG_NO (+)" ).append("\n"); 
		query.append("AND   C.CNTR_NO      = R.CNTR_NO (+)" ).append("\n"); 
		query.append("AND   C.BKG_NO       = B.BKG_NO" ).append("\n"); 
		query.append("AND   B.CMDT_CD      = CO.CMDT_CD (+)" ).append("\n"); 

	}
}