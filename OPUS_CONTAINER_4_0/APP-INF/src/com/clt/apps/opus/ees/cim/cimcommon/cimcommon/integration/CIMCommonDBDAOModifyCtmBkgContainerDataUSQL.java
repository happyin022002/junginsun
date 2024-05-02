/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CIMCommonDBDAOModifyCtmBkgContainerDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.17
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2015.09.17 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CIMCommonDBDAOModifyCtmBkgContainerDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CTM_BKG_CNTR 수정
	  * </pre>
	  */
	public CIMCommonDBDAOModifyCtmBkgContainerDataUSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration").append("\n"); 
		query.append("FileName : CIMCommonDBDAOModifyCtmBkgContainerDataUSQL").append("\n"); 
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
		query.append("UPDATE CTM_BKG_CNTR BC SET (" ).append("\n"); 
		query.append("	BC.CNMV_YR, " ).append("\n"); 
		query.append("	BC.CNMV_ID_NO, " ).append("\n"); 
		query.append("	BC.CNMV_CYC_NO, " ).append("\n"); 
		query.append("	BC.CNMV_STS_CD, " ).append("\n"); 
		query.append("	BC.CNMV_EVNT_DT" ).append("\n"); 
		query.append(") = " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("	SELECT /*+ INDEX_DESC(CM XAK2CTM_MOVEMENT) */" ).append("\n"); 
		query.append("          CM.CNMV_YR" ).append("\n"); 
		query.append("        , CM.CNMV_ID_NO" ).append("\n"); 
		query.append("        , CM.CNMV_CYC_NO" ).append("\n"); 
		query.append("        , CM.MVMT_STS_CD" ).append("\n"); 
		query.append("        , CM.CNMV_EVNT_DT" ).append("\n"); 
		query.append("    FROM  CTM_MOVEMENT CM" ).append("\n"); 
		query.append("    WHERE BC.BKG_NO = CM.BKG_NO" ).append("\n"); 
		query.append("    AND   BC.CNTR_NO = CM.CNTR_NO" ).append("\n"); 
		query.append("    AND   ROWNUM     = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE  BC.CNTR_NO     = @[cntr_no]" ).append("\n"); 
		query.append("AND    BC.BKG_NO      = @[bkg_no]" ).append("\n"); 
		query.append("AND    EXISTS ( " ).append("\n"); 
		query.append("			SELECT 'X'" ).append("\n"); 
		query.append("            FROM  CTM_MOVEMENT CM" ).append("\n"); 
		query.append("            WHERE BC.BKG_NO = CM.BKG_NO" ).append("\n"); 
		query.append("            AND    BC.CNTR_NO = CM.CNTR_NO" ).append("\n"); 
		query.append("            GROUP BY CM.BKG_NO, CM.CNTR_NO " ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}