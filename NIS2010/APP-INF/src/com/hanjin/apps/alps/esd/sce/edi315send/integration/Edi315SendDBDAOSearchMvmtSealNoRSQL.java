/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Edi315SendDBDAOSearchMvmtSealNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.26
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchMvmtSealNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG Seal No 없을 시 MVMT Seal No 참조
	  * </pre>
	  */
	public Edi315SendDBDAOSearchMvmtSealNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchMvmtSealNoRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_ASC (CM XPKCTM_MOVEMENT) */ REPLACE(REPLACE(NVL(CNTR_SEAL_NO, ' '), CHR(13), ''), CHR(10), '') CNMV_SEAL_NO" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT CM" ).append("\n"); 
		query.append(", SCE_COP_HDR SH" ).append("\n"); 
		query.append(", SCE_COP_DTL SD" ).append("\n"); 
		query.append("WHERE SH.BKG_NO = @[e_bkg_no]" ).append("\n"); 
		query.append("AND SH.CNTR_NO = @[e_cntr_no]" ).append("\n"); 
		query.append("AND SH.BKG_NO = CM.BKG_NO" ).append("\n"); 
		query.append("AND SH.CNTR_NO = CM.CNTR_NO" ).append("\n"); 
		query.append("AND SH.COP_NO = SD.COP_NO" ).append("\n"); 
		query.append("AND SD.ACT_CD IN ('FLWMLO','FLVMLO')" ).append("\n"); 
		query.append("AND CM.MVMT_STS_CD = 'VL'" ).append("\n"); 
		query.append("AND CM.CRNT_VSL_CD = SD.VSL_CD" ).append("\n"); 
		query.append("AND CM.CRNT_SKD_VOY_NO = SD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND CM.CRNT_SKD_DIR_CD = SD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND CM.ORG_YD_CD = SD.NOD_CD" ).append("\n"); 
		query.append("AND SH.POL_NOD_CD = SD.NOD_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}