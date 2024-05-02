/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GuaranteeCommonDBDAOSearchUSGuaranteeCntrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2010.02.04 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.common.guaranteecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GuaranteeCommonDBDAOSearchUSGuaranteeCntrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Info Inquiry ( BKG No, BL No, SC No, VVD )
	  * </pre>
	  */
	public GuaranteeCommonDBDAOSearchUSGuaranteeCntrInfoRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.common.guaranteecommon.integration").append("\n"); 
		query.append("FileName : GuaranteeCommonDBDAOSearchUSGuaranteeCntrInfoRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("(SELECT	CASE WHEN COUNT(B.BKG_NO) > 0" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("FROM	BKG_BOOKING B" ).append("\n"); 
		query.append(", BKG_CONTAINER C" ).append("\n"); 
		query.append("WHERE	B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND		C.CNTR_NO		= @[cntr_no]" ).append("\n"); 
		query.append("AND		B.BKG_NO		= @[bkg_no]" ).append("\n"); 
		query.append("AND		B.BKG_STS_CD IN ('F','W') ) VALID_BKG" ).append("\n"); 
		query.append(", C.CNTR_NO" ).append("\n"); 
		query.append(", C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", B.BKG_NO" ).append("\n"); 
		query.append(", B.BL_NO" ).append("\n"); 
		query.append(", B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD VVD_CD" ).append("\n"); 
		query.append(", B.SC_NO" ).append("\n"); 
		query.append("FROM	BKG_BOOKING B" ).append("\n"); 
		query.append(", BKG_CONTAINER C" ).append("\n"); 
		query.append("WHERE	B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND		C.CNTR_NO		= @[cntr_no]" ).append("\n"); 
		query.append("AND		B.BKG_NO		= @[bkg_no]" ).append("\n"); 
		query.append("AND		B.BKG_STS_CD IN ('F','W')" ).append("\n"); 

	}
}