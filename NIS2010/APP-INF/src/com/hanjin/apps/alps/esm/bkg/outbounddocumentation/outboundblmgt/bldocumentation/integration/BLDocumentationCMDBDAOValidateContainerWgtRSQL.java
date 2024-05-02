/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BLDocumentationCMDBDAOValidateContainerWgtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.25
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2013.04.25 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOValidateContainerWgtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ValidateContainerWgt 
	  *   - Validation : Any Container의 입력된 Weight가 
	  *      1) 연계 Source 화면의 Gross Weight의 110% 를 초과할 경우, 
	  *      2) 연계 Source 화면의 Tare Weight의 미만일 경우 아래 Pop-up message 생성
	  * </pre>
	  */
	public BLDocumentationCMDBDAOValidateContainerWgtRSQL(){
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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOValidateContainerWgtRSQL").append("\n"); 
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
		query.append("SELECT NVL(NVL(MST.CNTR_GRS_WGT,MDM.CNTR_TPSZ_LODG_WGT),0) " ).append("\n"); 
		query.append("       + ( NVL( NVL(MST.CNTR_GRS_WGT,MDM.CNTR_TPSZ_LODG_WGT), 0)  * 0.1 ) AS CNTR_GRS_WGT" ).append("\n"); 
		query.append("       , NVL(NVL(MST.TARE_WGT,MDM.CNTR_TPSZ_TARE_WGT),0)                  AS CNTR_TARE_WGT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT A.CNTR_TPSZ_CD, B.CNTR_GRS_WGT, B.TARE_WGT" ).append("\n"); 
		query.append("         FROM MST_CONTAINER A" ).append("\n"); 
		query.append("             ,MST_CNTR_SPEC B" ).append("\n"); 
		query.append("        WHERE A.CNTR_NO         = @[cntr_no]" ).append("\n"); 
		query.append("        AND   A.CNTR_TPSZ_CD    = NVL(@[cntr_tpsz_cd], A.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("        AND   B.CNTR_SPEC_NO(+) = A.CNTR_SPEC_NO" ).append("\n"); 
		query.append(") MST, MDM_CNTR_TP_SZ MDM" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   MDM.CNTR_TPSZ_CD(+) = MST.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND   MDM.DELT_FLG(+)     = 'N'" ).append("\n"); 

	}
}