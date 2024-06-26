/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchCaPrtlBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchCaPrtlBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CargoReleaseOrderDBDAOsearchCaPrtlBlRSQL
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchCaPrtlBlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchCaPrtlBlRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) PARTIAL_CNT,  --(1) PARTIAL 갯수 " ).append("\n"); 
		query.append("       NVL(SUM(DECODE(F.CSTMS_CLR_CD,'P',1,'Y',1,0)),0) ALL_C_IND, -- (2) (C)가 'P' OR 'Y'인 갯수." ).append("\n"); 
		query.append("       NVL(SIGN(COUNT(*) - SUM(DECODE(F.CSTMS_CLR_CD,'P',1,'Y',1,0))),0) PARTIAL_CLEAR  -- (3) PARTIAL된 B/L의 모든 (C)값이 'P' OR 'Y'이면 0 (CLEAR)" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_BL   A," ).append("\n"); 
		query.append("       BKG_CSTMS_ADV_CNTR B," ).append("\n"); 
		query.append("       BKG_CSTMS_ADV_BL   C," ).append("\n"); 
		query.append("       BKG_CSTMS_ADV_CNTR D," ).append("\n"); 
		query.append("       BKG_BOOKING        E," ).append("\n"); 
		query.append("       BKG_CSTMS_ADV_RSLT F," ).append("\n"); 
		query.append("       BKG_CGO_RLSE       G" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE A.CNT_CD     = 'CA'" ).append("\n"); 
		query.append("   AND A.BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("   AND A.CNT_CD     = B.CNT_CD" ).append("\n"); 
		query.append("   AND A.BL_NO      = B.BL_NO" ).append("\n"); 
		query.append("   AND A.VSL_CD     = C.VSL_CD" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = C.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND A.CSTMS_POL_CD = C.CSTMS_POL_CD" ).append("\n"); 
		query.append("   AND A.CSTMS_POD_CD = C.CSTMS_POD_CD" ).append("\n"); 
		query.append("   AND C.CNT_CD       = 'CA'" ).append("\n"); 
		query.append("   AND C.CNT_CD       = D.CNT_CD" ).append("\n"); 
		query.append("   AND C.BL_NO        = D.BL_NO" ).append("\n"); 
		query.append("   AND A.BL_NO        <> C.BL_NO" ).append("\n"); 
		query.append("   AND B.CNTR_NO      = D.CNTR_NO" ).append("\n"); 
		query.append("   AND C.BKG_NO       = E.BKG_NO" ).append("\n"); 
		query.append("   AND E.BKG_STS_CD   <> 'X'" ).append("\n"); 
		query.append("   AND A.BL_NO        = G.BL_NO" ).append("\n"); 
		query.append("   AND C.MF_NO IS NULL" ).append("\n"); 
		query.append("   AND F.CNT_CD       = C.CNT_CD" ).append("\n"); 
		query.append("   AND F.BL_NO        = C.BL_NO" ).append("\n"); 
		query.append("   AND F.CSTMS_SEQ    = (SELECT MAX(K.CSTMS_SEQ)" ).append("\n"); 
		query.append("                           FROM BKG_CSTMS_ADV_RSLT K" ).append("\n"); 
		query.append("                          WHERE K.CNT_CD = C.CNT_CD" ).append("\n"); 
		query.append("                            AND K.BL_NO  = C.BL_NO)" ).append("\n"); 

	}
}