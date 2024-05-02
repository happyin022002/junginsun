/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BLDocumentationCMDBDAOModifyCntrFlgByRfCgoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.16
*@LastModifier : 
*@LastVersion : 1.0
* 2011.05.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOModifyCntrFlgByRfCgoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCntrFlgByRfCgo
	  * 2011.05.16 이일민 [CHM-201110332] ALPS Transshipment 메뉴 오류 수정요청
	  * </pre>
	  */
	public BLDocumentationCMDBDAOModifyCntrFlgByRfCgoUSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOModifyCntrFlgByRfCgoUSQL").append("\n"); 
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
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("UPDATE /*+BYPASS_UJVC*/" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT B.BKG_NO, B.CNTR_NO," ).append("\n"); 
		query.append("           B.RC_FLG, B.RD_CGO_FLG," ).append("\n"); 
		query.append("           CASE WHEN R.CNTR_NO IS NOT NULL THEN 'Y' ELSE 'N' END T_RC_FLG," ).append("\n"); 
		query.append("           CASE WHEN R.CNTR_NO IS NOT NULL THEN 'N' ELSE 'Y' END T_RD_CGO_FLG" ).append("\n"); 
		query.append("    FROM BKG_CNTR_HIS B, BKG_RF_CGO_HIS R" ).append("\n"); 
		query.append("    WHERE B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    AND B.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("    AND B.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("    AND B.CNTR_NO = R.CNTR_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SET RC_FLG = T_RC_FLG," ).append("\n"); 
		query.append("    RD_CGO_FLG = T_RD_CGO_FLG" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE /*+BYPASS_UJVC*/" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT B.BKG_NO, B.CNTR_NO," ).append("\n"); 
		query.append("           B.RC_FLG, B.RD_CGO_FLG," ).append("\n"); 
		query.append("           CASE WHEN R.CNTR_NO IS NOT NULL THEN 'Y' ELSE 'N' END T_RC_FLG," ).append("\n"); 
		query.append("           CASE WHEN R.CNTR_NO IS NOT NULL THEN 'N' ELSE 'Y' END T_RD_CGO_FLG" ).append("\n"); 
		query.append("    FROM BKG_CONTAINER B, BKG_RF_CGO R" ).append("\n"); 
		query.append("    WHERE B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    AND B.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("    AND B.CNTR_NO = R.CNTR_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SET RC_FLG = T_RC_FLG," ).append("\n"); 
		query.append("    RD_CGO_FLG = T_RD_CGO_FLG" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}