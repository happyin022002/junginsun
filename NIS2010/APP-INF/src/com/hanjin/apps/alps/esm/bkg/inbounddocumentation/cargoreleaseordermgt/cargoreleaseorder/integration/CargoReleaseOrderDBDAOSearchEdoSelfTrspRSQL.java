/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchEdoSelfTrspRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 박성호
*@LastVersion : 1.0
* 2009.07.09 박성호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Sung Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchEdoSelfTrspRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UI_BKG_0136 화면에서 사용하는 SQL문
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchEdoSelfTrspRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqstNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tpCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchEdoSelfTrspRSQL").append("\n"); 
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
		query.append("SELECT A.EDO_RQST_NO," ).append("\n"); 
		query.append("A.EDO_RQST_SEQ," ).append("\n"); 
		query.append("DECODE(A.OWN_TRSP_CD,'A','A:자선운송','S','S:자가운송') AS OWN_TRSP_CD," ).append("\n"); 
		query.append("A.EDO_ISS_DT," ).append("\n"); 
		query.append("A.BD_DEP_AREA_NO," ).append("\n"); 
		query.append("B.VNDR_NM          AS BD_DEP_AREA_VNDR_NM," ).append("\n"); 
		query.append("A.BD_ARR_AREA_NO," ).append("\n"); 
		query.append("A.BD_ARR_AREA_NM," ).append("\n"); 
		query.append("C.VNDR_NM          AS BD_ARR_AREA_VNDR_NM," ).append("\n"); 
		query.append("A.GDS_DESC1," ).append("\n"); 
		query.append("A.GDS_DESC2," ).append("\n"); 
		query.append("A.GDS_DESC3," ).append("\n"); 
		query.append("A.GDS_DESC4," ).append("\n"); 
		query.append("A.MISC_DESC," ).append("\n"); 
		query.append("A.CRE_USR_ID," ).append("\n"); 
		query.append("A.CRE_DT," ).append("\n"); 
		query.append("A.UPD_USR_ID," ).append("\n"); 
		query.append("A.UPD_DT" ).append("\n"); 
		query.append("FROM BKG_EDO_SELF_TRSP  A," ).append("\n"); 
		query.append("BKG_EDO_VNDR       B," ).append("\n"); 
		query.append("BKG_EDO_VNDR       C," ).append("\n"); 
		query.append("BKG_EDO_MST        D" ).append("\n"); 
		query.append("WHERE A.EDO_RQST_NO      = @[rqstNo]" ).append("\n"); 
		query.append("AND A.EDO_RQST_SEQ     = (SELECT MAX(EDO_RQST_SEQ)" ).append("\n"); 
		query.append("FROM BKG_EDO_MST" ).append("\n"); 
		query.append("WHERE EDO_RQST_NO    = @[rqstNo]" ).append("\n"); 
		query.append("AND EDO_TP_CD      = @[tpCd])" ).append("\n"); 
		query.append("AND A.BD_DEP_AREA_NO   = B.VNDR_NO (+)" ).append("\n"); 
		query.append("AND B.VNDR_CLSS_CD (+) = '2'" ).append("\n"); 
		query.append("AND A.BD_ARR_AREA_NO   = C.VNDR_NO (+)" ).append("\n"); 
		query.append("AND C.VNDR_CLSS_CD (+) = '2'" ).append("\n"); 
		query.append("AND A.EDO_RQST_NO      = D.EDO_RQST_NO" ).append("\n"); 
		query.append("AND A.EDO_RQST_SEQ     = D.EDO_RQST_SEQ" ).append("\n"); 
		query.append("AND D.EDO_TP_CD        = @[tpCd]" ).append("\n"); 

	}
}