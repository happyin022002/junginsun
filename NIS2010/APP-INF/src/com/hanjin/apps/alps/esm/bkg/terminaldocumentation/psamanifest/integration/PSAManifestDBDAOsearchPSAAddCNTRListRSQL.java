/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PSAManifestDBDAOsearchPSAAddCNTRListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.09.09 박상훈
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

public class PSAManifestDBDAOsearchPSAAddCNTRListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG에서 Add된 CNTR을 조회한다.
	  * </pre>
	  */
	public PSAManifestDBDAOsearchPSAAddCNTRListRSQL(){
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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : PSAManifestDBDAOsearchPSAAddCNTRListRSQL").append("\n"); 
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
		query.append("SELECT C.CNTR_NO CNTR_NO" ).append("\n"); 
		query.append("FROM BKG_VVD V, BKG_BOOKING B, BKG_CONTAINER C, BKG_VVD NV" ).append("\n"); 
		query.append("WHERE  V.VSL_CD           = @[vsl_cd]" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO       = @[skd_voy_no]" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD       = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND    V.POD_CD           = @[pod_cd]" ).append("\n"); 
		query.append("AND    B.BKG_STS_CD NOT IN   ('X','S')" ).append("\n"); 
		query.append("AND    V.BKG_NO           = B.BKG_NO" ).append("\n"); 
		query.append("AND    V.BKG_NO           = C.BKG_NO" ).append("\n"); 
		query.append("AND    V.BKG_NO           = NV.BKG_NO" ).append("\n"); 
		query.append("AND    NV.VSL_PRE_PST_CD||NV.VSL_SEQ  = (SELECT NVL(MIN(VSL_PRE_PST_CD||VSL_SEQ), V.VSL_PRE_PST_CD||V.VSL_SEQ)" ).append("\n"); 
		query.append("FROM   BKG_VVD" ).append("\n"); 
		query.append("WHERE  BKG_NO       = V.BKG_NO" ).append("\n"); 
		query.append("AND    V.VSL_PRE_PST_CD||V.VSL_SEQ < VSL_PRE_PST_CD||VSL_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("MINUS" ).append("\n"); 
		query.append("SELECT CNTR_NO" ).append("\n"); 
		query.append("FROM   BKG_CSTMS_PSA_IMP_STS" ).append("\n"); 
		query.append("WHERE  VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("AND    SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("AND    SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 

	}
}