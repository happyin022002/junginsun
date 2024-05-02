/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOcheckEdoTransBlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.27
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOcheckEdoTransBlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 냉동화물의 존재여부 체크
	  * 2012.02.24 김보배 [CHM-201216327] [BKG] 수입 냉동화물에 대한 자가운송 규제관련(D/O, 자가운송 승인전 팝업요청)
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOcheckEdoTransBlInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOcheckEdoTransBlInfoRSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append("      ,A.POR_CD" ).append("\n"); 
		query.append("      ,A.RC_FLG" ).append("\n"); 
		query.append("      ,B.CNT_CD" ).append("\n"); 
		query.append("      ,C.CNT_NM" ).append("\n"); 
		query.append("      ,D.SCONTI_NM" ).append("\n"); 
		query.append("      ,E.CONTI_NM" ).append("\n"); 
		query.append("FROM BKG_BOOKING      A," ).append("\n"); 
		query.append("     MDM_LOCATION     B," ).append("\n"); 
		query.append("     MDM_COUNTRY      C," ).append("\n"); 
		query.append("     MDM_SUBCONTINENT D," ).append("\n"); 
		query.append("     MDM_CONTINENT    E" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND   B.LOC_CD(+) = A.POR_CD" ).append("\n"); 
		query.append("AND   C.CNT_CD(+) = B.CNT_CD" ).append("\n"); 
		query.append("AND   D.SCONTI_CD(+) = C.SCONTI_CD" ).append("\n"); 
		query.append("AND   E.CONTI_CD(+) = D.CONTI_CD" ).append("\n"); 

	}
}