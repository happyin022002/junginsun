/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : BLDocumentationCMDBDAOCntrSealNoModithCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.26
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.26 
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

public class BLDocumentationCMDBDAOCntrSealNoModithCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI Container Movement 발생할 시
	  * CNTR_SEAL_NO 등록 할지 여부 체크하는 쿼리
	  * </pre>
	  */
	public BLDocumentationCMDBDAOCntrSealNoModithCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOCntrSealNoModithCheckRSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y') " ).append("\n"); 
		query.append("SELECT 1" ).append("\n"); 
		query.append("FROM BKG_BKG_HIS BB" ).append("\n"); 
		query.append("     ,BKG_CNTR_HIS BC" ).append("\n"); 
		query.append("     ,MST_CONTAINER MC" ).append("\n"); 
		query.append("WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BB.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND BB.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("AND BC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND BC.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND BC.CNTR_NO = MC.CNTR_NO" ).append("\n"); 
		query.append("AND BB.POL_CD LIKE 'KR%'" ).append("\n"); 
		query.append("AND SUBSTR(MC.CNTR_TPSZ_CD, 1, 1) IN ('F','A')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT 1" ).append("\n"); 
		query.append("FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("     ,BKG_CONTAINER BC" ).append("\n"); 
		query.append("     ,MST_CONTAINER MC" ).append("\n"); 
		query.append("WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND BB.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("AND BC.CNTR_NO = MC.CNTR_NO" ).append("\n"); 
		query.append("AND BB.POL_CD LIKE 'KR%'" ).append("\n"); 
		query.append("AND SUBSTR(MC.CNTR_TPSZ_CD, 1, 1) IN ('F','A')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}