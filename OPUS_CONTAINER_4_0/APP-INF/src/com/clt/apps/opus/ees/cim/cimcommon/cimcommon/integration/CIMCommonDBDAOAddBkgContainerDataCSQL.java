/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CIMCommonDBDAOAddBkgContainerDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CIMCommonDBDAOAddBkgContainerDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_CONTAINER 신규저장
	  * </pre>
	  */
	public CIMCommonDBDAOAddBkgContainerDataCSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration ").append("\n"); 
		query.append("FileName : CIMCommonDBDAOAddBkgContainerDataCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CONTAINER BC" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    BC.CNTR_NO," ).append("\n"); 
		query.append("    BC.BKG_NO," ).append("\n"); 
		query.append("    BC.CNMV_YR, " ).append("\n"); 
		query.append("    BC.CNMV_ID_NO, " ).append("\n"); 
		query.append("    BC.CNMV_CYC_NO, " ).append("\n"); 
		query.append("    BC.CNMV_STS_CD, " ).append("\n"); 
		query.append("    BC.CNMV_EVNT_DT, " ).append("\n"); 
		query.append("    BC.ORG_YD_CD," ).append("\n"); 
		query.append("    BC.CRE_USR_ID," ).append("\n"); 
		query.append("    BC.UPD_USR_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[cntr_no] AS CNTR_NO , @[bkg_no] AS BKG_NO , MAX(CM.CNMV_YR)" ).append("\n"); 
		query.append("			,  SUBSTR(MAX(CM.CNMV_YR||TRIM(TO_CHAR(CM.CNMV_SEQ, '00000'))||NVL(CM.CNMV_SPLIT_NO, ' ')||TRIM(TO_CHAR(CM.CNMV_ID_NO, '00000'))), -5)" ).append("\n"); 
		query.append("			,  SUBSTR(MAX(CM.CNMV_YR||TRIM(TO_CHAR(CM.CNMV_SEQ, '00000'))||NVL(CM.CNMV_SPLIT_NO, ' ')||TRIM(TO_CHAR(CM.CNMV_CYC_NO, '0000'))), -4)" ).append("\n"); 
		query.append("			,  SUBSTR(MAX(CM.CNMV_YR||TRIM(TO_CHAR(CM.CNMV_SEQ, '00000'))||NVL(CM.CNMV_SPLIT_NO, ' ')||TRIM(CM.MVMT_STS_CD)), -2)" ).append("\n"); 
		query.append("			,  TO_DATE(SUBSTR(MAX(CM.CNMV_YR||TRIM(TO_CHAR(CM.CNMV_SEQ, '00000'))||NVL(CM.CNMV_SPLIT_NO, ' ')||TO_CHAR(CM.CNMV_EVNT_DT, 'YYYYMMDDHH24MISS')), -14), 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("			, SUBSTR(MAX(CM.CNMV_YR||TRIM(TO_CHAR(CM.CNMV_SEQ, '00000'))||NVL(CM.CNMV_SPLIT_NO, ' ')||TRIM(CM.ORG_YD_CD)), -7)" ).append("\n"); 
		query.append("            , 'AAA'" ).append("\n"); 
		query.append("            , 'AAA'" ).append("\n"); 
		query.append("        FROM  CTM_MOVEMENT CM" ).append("\n"); 
		query.append("        WHERE CM.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("		AND		ROWNUM   = 1" ).append("\n"); 

	}
}