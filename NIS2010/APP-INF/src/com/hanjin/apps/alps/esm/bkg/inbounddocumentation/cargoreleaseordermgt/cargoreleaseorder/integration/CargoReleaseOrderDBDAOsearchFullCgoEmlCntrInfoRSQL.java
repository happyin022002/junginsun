/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchFullCgoEmlCntrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.08
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.08 
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

public class CargoReleaseOrderDBDAOsearchFullCgoEmlCntrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EU_Cargo Release Order의 email 발송 시 컨테이너 정보를 조회한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchFullCgoEmlCntrInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchFullCgoEmlCntrInfoRSQL").append("\n"); 
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
		query.append("SELECT  ROWNUM AS CNTR_MF_SEQ" ).append("\n"); 
		query.append("      , A2.PCK_QTY                                                            -- Package" ).append("\n"); 
		query.append("      , A2.PCK_TP_CD" ).append("\n"); 
		query.append("      , Trim(to_char(A2.CNTR_MF_WGT, '999,999,990.000'))          AS CNTR_MF_WGT  -- Weight" ).append("\n"); 
		query.append("      , A2.WGT_UT_CD" ).append("\n"); 
		query.append("      , Trim(To_char(A2.MEAS_QTY, '999,999,999,999,990.000')) AS MEAS_QTY" ).append("\n"); 
		query.append("      , A2.MEAS_UT_CD " ).append("\n"); 
		query.append("      , REPLACE(SUBSTR(NVL(A2.CNTR_MF_MK_DESC,''),1,50),chr(13)||chr(10),chr(13)||chr(10)||'        ') AS CNTR_MF_MK_DESC  -- Marks" ).append("\n"); 
		query.append("      , SUBSTR(NVL(A2.CNTR_MF_GDS_DESC,''),1,50) AS CNTR_MF_GDS_DESC -- Description" ).append("\n"); 
		query.append("      , A2.CMDT_HS_CD               --  HS Code" ).append("\n"); 
		query.append("FROM    BKG_CONTAINER A1" ).append("\n"); 
		query.append("      , BKG_CNTR_MF_DESC A2     " ).append("\n"); 
		query.append("WHERE  A1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND     A1.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND     A2.BKG_NO = A1.BKG_NO" ).append("\n"); 
		query.append("AND     A2.CNTR_NO = A1.CNTR_NO" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("        A1.CNTR_DP_SEQ" ).append("\n"); 
		query.append("      , A2.CNTR_MF_SEQ" ).append("\n"); 

	}
}